package leetcode;

class Engine
{
	private Long enginePrice;

	public Engine(long enginePriceValue)
	{
		enginePrice = enginePriceValue;
		setEnginePrice(enginePrice);
	}

	public long getEnginePrice() {
		return enginePrice;
	}

	public void setEnginePrice(long enginePrice) {
		this.enginePrice = enginePrice;
	}
}

public class Cars extends Engine {
	
	private Long carPrice;

	public Cars(long enginePrice, long carPriceValue) {
		super(enginePrice);
		carPrice = carPriceValue;
		setCarPrice(carPrice);
	}
	
	public long getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(long carPrice) {
		this.carPrice = carPrice;
	}

	public static void main(String args[])
	{
		Cars obj = new Cars(150000,550000);
		System.out.println(obj.getCarPrice()+obj.getEnginePrice());	
	}

}
