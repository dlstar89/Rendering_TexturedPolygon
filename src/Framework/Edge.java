/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

/*
 * @author DI
 */
public class Edge
{
   private float m_yMin;
   private float m_yMax;
   private float m_xMin;
   private float m_zVal;
   private float m_inverseSlope;
   private float m_xStepSize;
   private float m_yStepSize;
   private float m_zStepSize;
   private Vector3 m_pointOne;
   private Vector3 m_pointTwo;

   public float getXStepSize()
   {
      return m_xStepSize;
   }
   
   public void setXStepSize(float stepsize)
   {
      m_xStepSize = stepsize;
   }
   
   public float getYStepSize()
   {
      return m_yStepSize;
   }
   
   public void setYStepSize(float stepsize)
   {
      m_yStepSize = stepsize;
   }
   
   public float getZStepSize()
   {
      return m_zStepSize;
   }
   
   public void setZStepSize(float stepsize)
   {
      m_zStepSize = stepsize;
   }
   
   public Vector3 getPointOne()
   {
      return m_pointOne;
   }

   public Vector3 getPointTwo()
   {
      return m_pointTwo;
   }

   public float getYmin()
   {
      return m_yMin;
   }

   public void setYmin(float yMin)
   {
      m_yMin = yMin;
   }

   public float getYmax()
   {
      return m_yMax;
   }

   public void setYmax(float yMax)
   {
      m_yMax = yMax;
   }

   public float getXmin()
   {
      return m_xMin;
   }

   public void setXmin(float xMin)
   {
      m_xMin = xMin;
   }

   public float getZval()
   {
      return m_zVal;
   }

   public void setZval(float z)
   {
      m_zVal = z;
   }

   public float getInverseSlope()
   {
      return m_inverseSlope;
   }

   public void setInverseSlope(float m)
   {
      m_inverseSlope = m;
   }

   public Edge()
   {
      m_yMin = 0;
      m_yMax = 0;
      m_xMin = 0;
      m_zVal = 0;
      m_inverseSlope = 0;
      m_pointOne = new Vector3();
      m_pointTwo = new Vector3();
   }

   public Edge(float yMin, float yMax, float xMin, float inverseSlope)
   {
      m_yMin = yMin;
      m_yMax = yMax;
      m_xMin = xMin;
      m_inverseSlope = inverseSlope;
      m_pointOne = new Vector3();
      m_pointTwo = new Vector3();
   }

   public String printEdge()
   {
      return "Y-Min:" + m_yMin + "|Y-Max:" + m_yMax + "|X-Min:" + m_xMin + "|m:" + m_inverseSlope;
   }
}
