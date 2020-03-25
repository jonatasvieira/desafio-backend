package com.ciandt.investment.core.usecase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ciandt.investment.core.domain.Fundo;
import com.ciandt.investment.core.domain.InformeDiario;

public class ObterCaptacaoLiquidaUseCase {

    private final InformeDiarioBoundary informeDiarioBoundary;

    public ObterCaptacaoLiquidaUseCase(InformeDiarioBoundary informeDiarioBoundary) {
        this.informeDiarioBoundary = informeDiarioBoundary;
    }
    
    public List<Fundo> obterDezMaioresFundos() {
    	
    	List<Fundo> fundos = new ArrayList<Fundo>();
    	Map<String, List<InformeDiario>> fundosAgrupgadosPorCpnj = informeDiarioBoundary.obterInformesDiarios().stream().collect(Collectors.groupingBy(informeDiario -> informeDiario.getCnpj()));
    	
    	
    	fundosAgrupgadosPorCpnj.entrySet().stream().forEach(informe -> {
    		Fundo fundo = new Fundo(informe.getKey());
    		informe.getValue().forEach(informeDiario -> {
    			fundo.setCaptacaoLiquida(fundo.getCaptacaoLiquida().add(informeDiario.getCaptacaoLiquida()));
    		});
    		fundos.add(fundo);
    	});
    	
    	return fundos.stream().sorted(Comparator.comparing(Fundo::getCaptacaoLiquida).reversed()).limit(10).collect(Collectors.toList());
    	
    }
    
}
