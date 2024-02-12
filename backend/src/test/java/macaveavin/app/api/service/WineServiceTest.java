package macaveavin.app.api.service;

import macaveavin.app.api.dto.WineDto;
import macaveavin.app.api.entity.Wine;
import macaveavin.app.api.repository.WineRepository;
import macaveavin.app.api.service.mapper.WineMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class WineServiceTest {
    @Mock
    private WineRepository wineRepository;

    @Mock
    private WineMapper wineMapper;

    @Mock
    private SharedServices sharedServices;

    @InjectMocks
    private WineService wineService;

    public WineServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getWines() {
        //Mock
        List<Wine> wines = Arrays.asList(new Wine(), new Wine());
        when(wineRepository.findAll()).thenReturn(wines);
        when(wineMapper.convertToDto(any())).thenReturn(new WineDto());

        List<WineDto> winesDto = wineService.getWines();
        assertEquals(2, winesDto.size());
        verify(wineRepository, times(1)).findAll();
        verify(wineMapper, times(2)).convertToDto(any());
    }

    @Test
    void getWine() {
        //Mock
        Wine wine = new Wine();
        when(wineRepository.findById(anyLong())).thenReturn(Optional.of(wine));
        when(wineMapper.convertToDto(any())).thenReturn(new WineDto());

        WineDto wineDto = wineService.getWine(1L);
        verify(wineRepository, times(1)).findById(1L);
        verify(wineMapper, times(1)).convertToDto(any());
    }

    @Test
    void updateWine() {
    }

    @Test
    void createNewWine() {
        // Mock
/*        WineDto wineDto = new WineDto();
        Wine wineEntity = new Wine();
        when(wineMapper.convertToEntity(wineDto)).thenReturn(wineEntity);
        when(wineRepository.save(wineEntity)).thenReturn(wineEntity);
        when(wineMapper.convertToDto(wineEntity)).thenReturn(wineDto);

        WineDto createdWineDto = wineService.createNewWine(wineDto);

        assertNotNull(createdWineDto);
        assertEquals(wineDto, createdWineDto);
        verify(wineMapper, times(1)).convertToEntity(wineDto);
        verify(wineRepository, times(1)).save(wineEntity);
        verify(wineMapper, times(1)).convertToDto(wineEntity);*/
    }

    @Test
    void deleteWine() {
    }
}