package com.ciandt.investment.core.usecase;

import com.ciandt.investment.core.domain.Fundo;
import com.ciandt.investment.core.domain.InformeDiario;
import com.ciandt.investment.dataprovider.InformeDiarioGateway;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ObterCaptacaoLiquidaUseCaseTest {

    private ObterCaptacaoLiquidaUseCase obterCaptacaoLiquidaUseCase;
    private InformeDiarioBoundary informeDiarioBoundary;

    @Before
    public void setup() {
        informeDiarioBoundary = new InformeDiarioGateway();
        obterCaptacaoLiquidaUseCase = new ObterCaptacaoLiquidaUseCase(informeDiarioBoundary);
    }

    @Test
    public void deveObterOsDadosdeInformesDiario() {

        List<InformeDiario> all = informeDiarioBoundary.getAll();
        Assert.assertEquals(325850, all.size());
    }
    
    @Test
    public void deveObterDezMaioresFundos() {
    	List<Fundo> dezMaioresFundos = obterCaptacaoLiquidaUseCase.obterDezMaioresFundos();
    	Assert.assertEquals(10, dezMaioresFundos.size());
    }

}