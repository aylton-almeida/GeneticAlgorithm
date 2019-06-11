package Genetics;

public class Gene {
    private String description;
    private boolean isActive;

    public Gene(String description, boolean isActive){
        setDescription(description);
        setActive(isActive);
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

    @Override
    public String toString(){
        return this.description + ": " + this.isActive;
    }
}
