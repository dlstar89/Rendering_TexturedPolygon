/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

/*@author DI*/
public class Vector3
{
   private float x, y, z;
   private float xMapCord, yMapCord;

   public float GetX()
   {
      return this.x;
   }

   public void SetX(float x)
   {
      this.x = x;
   }

   public float GetY()
   {
      return this.y;
   }

   public void SetY(float y)
   {
      this.y = y;
   }

   public float GetZ()
   {
      return this.z;
   }

   public void SetZ(float z)
   {
      this.z = z;
   }
   
   public float getXMapCoord()
   {
      return this.xMapCord;
   }
   
   public void setXMapCoord(float xMapCoord)
   {
      this.xMapCord = xMapCoord;
   }
   
   public float getYMapCoord()
   {
      return this.yMapCord;
   }
   
   public void setYMapCoord(float yMapCoord)
   {
      this.yMapCord = yMapCoord;
   }

   //default constructor
   public Vector3()
   {
      this.x = 0;
      this.y = 0;
      this.z = 0;
      this.xMapCord = 0;
      this.yMapCord = 0;
   }

   public Vector3(float x, float y, float z)
   {
      this.x = x;
      this.y = y;
      this.z = z;
      this.xMapCord = 0;
      this.yMapCord = 0;
   }

   public Vector3(float x, float y, float z, float xMapCord, float yMapCord)
   {
      this.x = x;
      this.y = y;
      this.z = z;
      this.xMapCord = xMapCord;
      this.yMapCord = yMapCord;
   }

   public Vector3 Normalize()
   {
      float length;

      length = (float) (Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));

      length = (float) Math.sqrt(length);

      return new Vector3((float) (this.x / length), (float) (this.y / length), (float) (this.z / length));
   }

   public String printVector()
   {
      return "X: " + this.x + ", Y: " + this.y + ", Z: " + this.z;
   }
}
