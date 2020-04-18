package cn.dqb.entity;

/**
 * @author baes
 * @date 2018/8/16 15:16
 *
 */
public class Good {
	private Long id;

	private String price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Good{" + "id=" + id + ", price='" + price + '\'' + '}';
	}
}
