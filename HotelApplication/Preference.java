import java.util.List;

public class Preference  {
   private int ratingPreference;
  // private int costPerDay;
   private int days;
   private List<String> sortPrefs;
   private int totalBudget;
   
public int getDays() {
	return days;
}
public void setDays(int days) throws Exception {
	if(days < 1 || days > 31) throw new Exception("Enter valid num of days");
	this.days = days;
}
public int getRatingPreference() {
	return ratingPreference;
}
public void setRatingPreference(int ratingPreference)  throws Exception{
	if(ratingPreference == 1 || ratingPreference == 3|| ratingPreference == 5 )
	{
		this.ratingPreference = ratingPreference;
	}
	else
	{
		throw new Exception("Enter a valid rating");
	}

}
public List<String> getSortPrefs() {
	return sortPrefs;
}
public void setSortPrefs(List<String> sortPrefs) {
	this.sortPrefs = sortPrefs;
}
public int getTotalBudget() {
	return totalBudget;
}
public void setTotalBudget(int totalBudget) throws Exception {
	if(totalBudget  != (int)totalBudget) throw new Exception ("Enter a valid budget amount");
	this.totalBudget = totalBudget;
}




}
