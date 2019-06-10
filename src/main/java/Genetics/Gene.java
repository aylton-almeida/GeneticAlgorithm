package Genetics;

public class Gene {
    private String description;
    private boolean isActive;

    public Gene(String description, boolean isActive){
        setDescription(description);
        setActive(true);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
