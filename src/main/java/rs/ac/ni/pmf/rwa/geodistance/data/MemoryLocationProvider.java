package rs.ac.ni.pmf.rwa.geodistance.data;

import rs.ac.ni.pmf.rwa.geodistance.core.LocationProvider;
import rs.ac.ni.pmf.rwa.geodistance.core.model.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemoryLocationProvider implements LocationProvider
{
	private final Map<String, Location> locations = Map.of(
		"AB10 1XG", new Location("AB10 1XG", 57.144156, -2.114864),
		"AB10 6RN", new Location("AB10 6RN", 57.137871, -2.121487)
	);

	@Override
	public Location getLocation(String postalCode)
	{
		return locations.get(postalCode);
	}

	@Override
	public List<Location> getLocations()
	{
		return new ArrayList<>(locations.values());
	}
}
