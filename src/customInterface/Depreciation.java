package customInterface;

import java.time.LocalDate;

public interface Depreciation {
	
	public void calculateDepreciationRate();
	public void calculateDepreciation(LocalDate toDate);
	public void deregisterForDepreciation();
}
