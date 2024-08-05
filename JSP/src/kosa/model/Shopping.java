package kosa.model;

public class Shopping {
    private String product_id;
    private String product_name;
    private String id;
    
    public Shopping() {}
    

    public Shopping(String product_id, String product_name, String id) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.id = id;
	}

	public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


	@Override
	public String toString() {
		return "Shopping [product_id=" + product_id + ", product_name=" + product_name + ", id=" + id + "]";
	}
    
    
}
