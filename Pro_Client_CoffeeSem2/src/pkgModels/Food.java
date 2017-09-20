package pkgModels;
public class Food {
    byte[] photoFood;
    String nameFood;
    float priceFood;

    public Food(byte[] photoFood, String nameFood, float priceFood) {
        this.photoFood = photoFood;
        this.nameFood = nameFood;
        this.priceFood = priceFood;
    }

    public Food() {
   
    }

    public byte[] getPhotoFood() {
        return photoFood;
    }

    public void setPhotoFood(byte[] photoFood) {
        this.photoFood = photoFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public float getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(float priceFood) {
        this.priceFood = priceFood;
    }
    
    
}
