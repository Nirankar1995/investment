package com.investment.service.vertex.factory;

import com.investment.dto.VertexServiceType;
import com.investment.service.vertex.IVertexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class VertexFactory {

    private Map<VertexServiceType, IVertexService> vertexServiceMap;

    @Autowired
    public VertexFactory(Set<IVertexService> iVertexServices){
        createInvestmentServiceInstance(iVertexServices);
    }

    private void createInvestmentServiceInstance(Set<IVertexService> iVertexServices) {
        vertexServiceMap = new HashMap<>();
        iVertexServices.forEach(service -> vertexServiceMap.put(service.getVertexServiceType(), service));
    }

    public IVertexService getServiceInstance(VertexServiceType vertexServiceType){
        return vertexServiceMap.get(vertexServiceType);
    }

}
