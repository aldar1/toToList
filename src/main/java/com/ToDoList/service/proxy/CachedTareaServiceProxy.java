package com.ToDoList.service.proxy;

import com.ToDoList.dto.request.TareaRequest;
import com.ToDoList.dto.response.TareaResponse;
import com.ToDoList.service.TareaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service(value = "cachedTareaServiceProxy")
@Primary
public class CachedTareaServiceProxy implements TareaService {

    private static final Logger log = LoggerFactory.getLogger(CachedTareaServiceProxy.class);

    private final TareaService delegate;
    private final Map<Long, TareaResponse> cache = new ConcurrentHashMap<>();
    private List<TareaResponse> listaCacheada;

    public CachedTareaServiceProxy(TareaService delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<TareaResponse> findAll() {
        if (listaCacheada != null) {
            log.info("Cache HIT: lista de tareas obtenida desde memoria");
            return listaCacheada;
        }
        listaCacheada = delegate.findAll();
        return listaCacheada;
    }

    @Override
    public TareaResponse findById(Long id) {
        if (cache.containsKey(id)) {
            log.info("Cache HIT: tarea obtenida desde memoria");
            return cache.get(id);
        }

        TareaResponse tareaResponse = delegate.findById(id);
        cache.put(id, tareaResponse);
        return tareaResponse;

    }

    @Override
    public TareaResponse save(TareaRequest tareaRequest) {
        invalidarCache();
        return delegate.save(tareaRequest);
    }

    @Override
    public TareaResponse update(Long id) {
        invalidarCache();
        return delegate.update(id);
    }

    @Override
    public void delete(Long id) {
        invalidarCache();
        cache.remove(id);
        delegate.delete(id);
    }

    private void invalidarCache() {
        log.info("Cache HIT: cache eliminado de la tarea");
        listaCacheada = null;
    }
}
