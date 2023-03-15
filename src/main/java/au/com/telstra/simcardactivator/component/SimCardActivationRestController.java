package au.com.telstra.simcardactivator.component;

import au.com.telstra.simcardactivator.foundation.SimCard;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.telstra.simcardactivator.foundation.SimCard;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SimCardActivationRestController {
    private final Database database;
    private final SimCardActuationHandler simCardActuationHandler;
    @PostMapping(value = "/activate")
    public void handleActivationRequest(@RequestBody SimCard simCard) {
        var actuationResult = simCardActuationHandler.actuate(simCard);
        database.save(simCard, actuationResult);
    }

    @GetMapping(value = "/query")
    public SimCard handleActivationRequest(@RequestParam Long simCardId) {
        return database.querySimCard(simCardId);
    }
}
