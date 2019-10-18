package org.patsimas.multi_data_source_service.controllers;

import lombok.extern.slf4j.Slf4j;
import org.patsimas.multi_data_source_service.services.MultiDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MultiDataSourceController {

    @Autowired
    MultiDataSourceService multiDataSourceService;

    @GetMapping(value = "data/{unit}", produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getMultiDataSource(@PathVariable("unit") Integer unit) {

        log.info("Fetch data with unit: {} ",unit);

        Object multiSourceData = multiDataSourceService.getMultiDataSourceByUnit(unit);

        return multiSourceData;
    }
}
