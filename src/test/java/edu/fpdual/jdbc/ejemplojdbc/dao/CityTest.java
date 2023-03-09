package edu.fpdual.jdbc.ejemplojdbc.dao;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CityTest {

    @Mock
    private ResultSet resultSet;

    @Test
    public void cityConstruction_ok() throws SQLException {

        City expectedCity = City.builder()
                .name("Alicante")
                .population(new BigInteger("300000"))
                .countryCode("ESP")
                .district("Alicante")
                .id(10000000)
                .build();

        doReturn(expectedCity.getId()).when(resultSet).getInt(any());
        when(resultSet.getBigDecimal(any())).thenReturn(new BigDecimal(expectedCity.getPopulation()));
        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("Name")){
                    return expectedCity.getName();
                } else if(invocationOnMock.getArgument(0).equals("District")) {
                    return expectedCity.getDistrict();
                } else if(invocationOnMock.getArgument(0).equals("CountryCode")) {
                    return expectedCity.getCountryCode();
                }else{
                    return null;
                }
            }
        });

        City actualCity = new City(resultSet);

        MatcherAssert.assertThat(actualCity, Matchers.is(expectedCity));

    }

}
