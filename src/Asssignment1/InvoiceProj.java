package Asssignment1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceProj {
	public static void main(String [] args) throws Exception {	
		
		
		//Food f=rice(2,chicken(mutton(1)));
		Food f=new Rice(1,new Chicken(2,new Mutton(5,new Vegfry(3))));	
		// STATIC COMPOSITION
		System.out.print(f.getDetails());
		String s=f.getDetails();
		String[] sp=s.split("\n");
		List<String> l=new ArrayList<>();
		Map<String,String> m=new HashMap<String,String>();
		for(String u:sp) {
			String[] up=u.split(":");
			m.put(up[0], up[1]);
		}
		double sgst=f.cost()*0.015;
		double cgst=f.cost()*0.015;
		double discount=(f.cost()+sgst+cgst)*0.05;
		double total=f.cost()+sgst+cgst-discount;
		m.put("sgst",(String)(f.cost()*0.015+""));
		m.put("cgst", (String)(f.cost()*0.015+""));
		m.put("discount", discount+"");
		m.put("total",total+"");
		LocalDateTime t=LocalDateTime.now();
		LocalDate d=LocalDate.now();
		ExcelReadWrite excel=new ExcelReadWrite();
		long mt=System.currentTimeMillis();
		excel.main(m,mt);
		PDFCreation pdf=new PDFCreation();
		pdf.main(m,mt);
		System.out.print(m);
		System.out.print("cost of food of rice and chicken"+f.cost());
	}



}
abstract class Food{									//PART WHOLE HIERARCHY 
	public abstract int cost() ;
	public abstract String getDetails();
}
abstract class VegFood extends Food{
	
}
abstract class NonVegFood extends Food{
	
}

class Rice extends VegFood{
	Food food;
	int Units;
	public Rice() {
		this.Units=0;
	}
	public Rice(int u) {
		this.Units=u;
	}
	public Rice(Food food) {
		Units=1;
		this.food=food;
	}
	public Rice(int u,Food food) {
		this.food=food;
		this.Units=u;
	}
	@Override
	public int cost() {
		if(food!=null) {
			return Units*10+food.cost();
		}
		else {
		return Units*10;
		}
	}
	@Override
	public String getDetails() {
		if(food!=null) {
		return food.getDetails()+"Rice:"+this.Units+"\n";
		}
		else {
			return "Rice:"+this.Units+"\n";
		}
	}
}
class Daal extends VegFood{
	Food food;
	int Units;
	public Daal() {
		Units=0;
	}
	public Daal(int u) {
		Units=u;
	}
	public Daal(Food food) {
		Units=1;
		this.food=food;
	}
	public Daal(int u,Food food) {
		this.food=food;
		this.Units=u;
	}
	@Override
	public int cost() {
		if(food!=null) {
			return Units*5+food.cost();
		}
		else {
		return Units*5;
		}
	}
	@Override
	public String getDetails() {
		if(food!=null) {
			return food.getDetails()+"Daal:"+this.Units+"\n";
			}
			else {
				return "Daal:"+this.Units+"\n";
			}}
}
class Vegfry extends VegFood{
	Food food;
	int Units;
	public Vegfry() {
		Units=0;
	}
	public Vegfry(int u)
	{this.Units=u;
	}
	public Vegfry(Food food) {
		Units=1;
		this.food=food;
	}
	public Vegfry(int u,Food food) {
		this.food=food;
		this.Units=u;
	}
	@Override
	public int cost() {
		if(food!=null) {
			return Units*15+food.cost();
		}
		else {
		return Units*15;
		}
	}
	@Override
	public String getDetails() {
		if(food!=null) {
			return food.getDetails()+"Vegfry:"+this.Units+"\n";
			}
			else {
				return "Vegfry:"+this.Units+"\n";
			}}
}
class Chicken extends NonVegFood{
	Food food;
	int Units;
	public Chicken() {
		Units=0;
	}
	public Chicken(int u) {
		this.Units=u;	}
	public Chicken(Food food) {
		Units=1;
		this.food=food;
	}
	public Chicken(int u,Food food) {
		this.food=food;
		this.Units=u;
	}
	@Override
	public int cost() {
		if(food!=null) {
			return Units*20+food.cost();
		}
		else {
		return Units*20;
		}
	}
	@Override
	public String getDetails() {
		if(food!=null) {
			return food.getDetails()+"Chicken:"+this.Units+"\n";
			}
			else {
				return "Chicken:"+this.Units+"\n";
			}}
}
class Mutton extends NonVegFood{
	Food food;
	int Units;
	public Mutton() {
		Units=0;
	}
	public Mutton(int u) {
		this.Units=u;
	}
	public Mutton(Food food) {
		Units=1;
		this.food=food;
	}
	public Mutton(int u,Food food) {
		this.food=food;
		this.Units=u;
	}
	@Override
	public int cost() {
		if(food!=null) {
			return Units*25+food.cost();
		}
		else {
		return Units*25;
		}
	}
	@Override
	public String getDetails() {
		if(food!=null) {
			return food.getDetails()+"Mutton:"+this.Units+"\n";
			}
			else {
				return "Mutton:"+this.Units+"\n";
			}
		}
}