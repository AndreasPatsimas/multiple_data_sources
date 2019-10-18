package org.patsimas.multi_data_source_service.services;

import org.springframework.stereotype.Service;

@Service
public interface MultiDataSourceService {

    Object getMultiDataSourceByUnit(Integer unit);
}
