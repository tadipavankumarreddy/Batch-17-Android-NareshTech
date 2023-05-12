
package in.nareshtech.samachar.model;

import java.util.List;
// ctrl+alt+o -> removes unused packages

public class Source {

    private String category;
    private List<Datum> data;
    private Boolean success;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Source() {
    }

    /**
     * 
     * @param data
     * @param success
     * @param category
     */
    public Source(String category, List<Datum> data, Boolean success) {
        super();
        this.category = category;
        this.data = data;
        this.success = success;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
