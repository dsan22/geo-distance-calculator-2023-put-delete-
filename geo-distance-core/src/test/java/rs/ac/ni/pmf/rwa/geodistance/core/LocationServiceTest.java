package rs.ac.ni.pmf.rwa.geodistance.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.ac.ni.pmf.rwa.geodistance.core.model.Location;
import rs.ac.ni.pmf.rwa.geodistance.exception.UnknownLocationException;

import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class LocationServiceTest {

    @Mock
    private LocationProvider locationProvider;

    @InjectMocks
    private LocationService locationService;


    @Test
    public void shouldGetAllLocations(){

        final List<Location> expectedLocations= mock(List.class);
        when(locationProvider.getLocations())
                .thenReturn(expectedLocations);

        final List<Location> actualLocations=locationService.getLocations();

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Test
    public void shouldGetAllLocationIfExists(){
        final Location expectedLocation =mock(Location.class);
        when(locationProvider.getLocation("X"))
                .thenReturn(Optional.of(expectedLocation));

        final Location actualLocation =locationService.getLocation("X");

        assertThat(actualLocation).isEqualTo(expectedLocation);
    }

    @Test
    public void shouldThrowWhereNoLocations(){
        when(locationProvider.getLocation("X"))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> locationService.getLocation("X"))
                .isInstanceOf(UnknownLocationException.class)
                .hasMessage("Unknown location for postal code 'X'");
    }




}