package com.github.krezovic.resttemplate_bug;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTemplateBugController {
    @PatchMapping(params = "v1")
    public void patchV1(@RequestBody String test) {
        // do nothing
    }
}
