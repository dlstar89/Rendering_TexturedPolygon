/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import Application.DrawApplication;
import java.awt.Color;
import java.awt.Graphics;

/*@author DI*/
public class Light
{
   private Vector3 m_position;
   private Color m_color;
   private Vector3 m_viewPoint;
   private Vector3 m_lightVector;
   private Vector3 m_reflectedVector;
   private Vector3 m_viewVector;
   private float m_diffuseCosine;
   private float m_specularCosine;
   private boolean m_isSelected = false;

   public void setIsSelected(boolean isSelected)
   {
      m_isSelected = isSelected;
   }
   
   public boolean checkIfSelected()
   {
      return m_isSelected;
   }

   public Vector3 getPostion()
   {
      return m_position;
   }

   public void setXPosition(float xPosition)
   {
      m_position.SetX(xPosition);
   }

   public void setYPosition(float yPosition)
   {
      m_position.SetY(yPosition);
   }

   public void setZPosition(float zPosition)
   {
      m_position.SetZ(zPosition);
   }

   public Light(Vector3 position, Color color)
   {
      m_position = position;
      m_color = color;
   }

   public void drawSelectedPosition(Graphics g)
   {
      if (m_isSelected)
      {
         g.setColor(m_color);
         g.drawString("Selected Light", (int) m_position.GetX(), (int) m_position.GetY());
      }
   }

   public void drawPosition(Graphics g)
   {
      g.setColor(m_color);
      g.drawString("L", (int) m_position.GetX(), (int) m_position.GetY());
   }

   public float getIntensity(Primitive polygon, Vector3 polygonPoint, Vector3 viewPoint, int n)
   {
      m_viewPoint = viewPoint;

      float iDr = getDiffuseReflection(polygonPoint, polygon.getPlaneNormal()) * polygon.getKd();

      float iDs = getSpecularReflection(polygon.getPlaneNormal(), polygonPoint, polygon.getKs(), n);


      return Math.abs(iDr + iDs);
   }

   public float getIntensity(Primitive polygon, Vector3 polygonPoint, Vector3 viewPoint, int n, Color color)
   {
      m_viewPoint = viewPoint;

      Vector3 normal = polygon.getPlaneNormal();

      float rotateIncr = (color.getBlue()) * polygon.getBumpMapStrength();

      normal = DrawApplication.g_MY_MATH_LIB.transform3DRotateX(normal, rotateIncr);

      normal = DrawApplication.g_MY_MATH_LIB.transform3DRotateY(normal, rotateIncr);

      normal = DrawApplication.g_MY_MATH_LIB.transform3DRotateZ(normal, -rotateIncr * 0.9f);

      normal = normal.Normalize();

      float iDr = getDiffuseReflection(polygonPoint, normal) * polygon.getKd();

      float iDs = getSpecularReflection(normal, polygonPoint, polygon.getKs(), n);

      return Math.abs(iDr + iDs);
   }

   private float getDiffuseReflection(Vector3 polygonPoint, Vector3 polygonNormal)
   {
      m_lightVector = DrawApplication.g_MY_MATH_LIB.getLightVector(polygonPoint, m_position);

      m_diffuseCosine = DrawApplication.g_MY_MATH_LIB.getDotProduct(m_lightVector, polygonNormal);

      return m_diffuseCosine;
   }

   private float getSpecularReflection(Vector3 polygonNormal, Vector3 polygonPoint, float kS, int n)
   {
      m_reflectedVector = DrawApplication.g_MY_MATH_LIB.getReflectedVector(m_lightVector, m_diffuseCosine, polygonNormal);

      m_viewVector = DrawApplication.g_MY_MATH_LIB.getViewVector(polygonPoint, m_viewPoint);

      m_specularCosine = DrawApplication.g_MY_MATH_LIB.getDotProduct(m_viewVector, m_reflectedVector);

      m_specularCosine = (float) Math.pow(m_specularCosine, n);

      m_specularCosine = kS * m_specularCosine;

      return m_specularCosine;
   }
}
