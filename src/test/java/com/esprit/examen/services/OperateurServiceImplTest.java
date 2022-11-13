package com.esprit.examen.services;


import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class OperateurServiceImplTest {

    OperateurRepository operateurRepository = Mockito.mock(OperateurRepository.class);

    @InjectMocks
    OperateurServiceImpl operateurService;

    Operateur op = Operateur.builder().prenom("ahmed").nom("Ahmed").password("123456").idOperateur(1L).build();

    List<Operateur> operateurs = new ArrayList<Operateur>(){
        {
            add(Operateur.builder().prenom("ahmed").nom("Ahmed").password("123456").idOperateur(1L).build());
            add(Operateur.builder().prenom("ahmed").nom("aa").password("123456").idOperateur(2L).build());
            add(Operateur.builder().prenom("ahmed").nom("bb").password("123456").idOperateur(3L).build());
            add(Operateur.builder().prenom("ahmed").nom("cc").password("123456").idOperateur(4L).build());
        }
    };

    @Test
    public void getOneOperator(){
        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(this.op));
        Operateur ope = operateurService.retrieveOperateur((long) 2);
        assertNotNull(ope);
        Mockito.verify(operateurRepository).findById(Mockito.anyLong());
    }
    @Test
    public void addOperateur(){
        Operateur opp = Operateur.builder().prenom("ahmed").nom("Ahmed").password("123456").idOperateur(1L).build();
        Mockito.when(operateurRepository.save(opp)).thenReturn(opp);
        Operateur oyp = operateurService.addOperateur(opp);
        assertNotNull(oyp);
        Mockito.verify(operateurRepository).save(opp);
    }
}
