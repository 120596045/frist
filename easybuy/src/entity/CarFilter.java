package entity;

public class CarFilter {
	
	private Car car;
	private Integer car_num;
	private Double car_price;
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Integer getCar_num() {
		return car_num;
	}
	public void setCar_num(Integer car_num) {
		this.car_num = car_num;
	}
	public Double getCar_price() {
		return car_price;
	}
	public void setCar_price(Double car_price) {
		this.car_price = this.car_num*this.car.getG_price();
	}
	
	
}
