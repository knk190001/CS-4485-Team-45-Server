package edu.utdallas.cs4485.team45.server;

import edu.utdallas.cs4485.team45.server.entities.GameEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

@RestController
@RequestMapping("/api")
public class GameEventController {
    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();
    private final Log logger = LogFactory.getLog(GameEventController.class);

    public void addPlayer(SseEmitter emitter) {
        emitters.add(emitter);
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        emitter.onError((error) -> {
            logger.error("Error in emitter", error);
            emitters.remove(emitter);
        });
    }

    public void emitEvent(GameEvent event) {
        List<SseEmitter> deadEmitters = new ArrayList<>();
        emitters.forEach(emitter -> {
            try {
                emitter.send(event);
            } catch (Exception e) {
                logger.error("Error sending event to emitter", e);
                deadEmitters.add(emitter);
            }
        });
        emitters.removeAll(deadEmitters);
    }

    public void clear() {
        emitters.forEach(ResponseBodyEmitter::complete);
        emitters.clear();
    }

    @GetMapping(value = "/game/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter gameEvents() {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        addPlayer(emitter);
        return emitter;
    }
}
