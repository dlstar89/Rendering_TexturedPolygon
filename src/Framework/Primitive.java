/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import Application.DrawApplication;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*@author DI*/
public class Primitive
{
   private Vector3[] m_originalVertecies;
   private Vector3[] m_vertecies;
   private Vector3 m_planeNormal;
   private ArrayList<Edge> m_edges = new ArrayList<Edge>();
   private BufferedImage m_image = null;
   private BufferedImage m_BumpMap = null;
   private Color m_color = new Color(Color.GREEN.getRGB());
   private int m_Texturecolors[][];
   private int m_BumpMapcolors[][];
   private float m_kD = 0;
   private float m_kS = 0f;
   private float m_bumpMapStrength = 0.5f;
   private boolean m_isSelected = false;

   public void setSelectedState(boolean selected)
   {
      m_isSelected = selected;
   }

   public Vector3 getPlaneNormal()
   {
      return m_planeNormal;
   }

   public float getBumpMapStrength()
   {
      return m_bumpMapStrength;
   }

   public void setBumpMapStrength(float bumpMapStrength)
   {
      m_bumpMapStrength = bumpMapStrength;
   }

   public void setNewTexture(String texture)
   {
      m_Texturecolors = getRGB(getImage(texture));
   }

   public void setNewBumpMap(String bumpMap)
   {
      m_BumpMapcolors = getRGB(getImage(bumpMap));
   }

   public float getKd()
   {
      return m_kD;
   }

   public void setKd(float kD)
   {
      m_kD = kD;
   }

   public float getKs()
   {
      return m_kS;
   }

   public void setKs(float kS)
   {
      m_kS = kS;
   }

   public BufferedImage getImage()
   {
      return m_image;
   }

   public Vector3[] getVerticies()
   {
      return m_vertecies;
   }

   public Color getColor()
   {
      return m_color;
   }

   public int[][] getTextureColors()
   {
      return m_Texturecolors;
   }

   public int[][] getBumpMapColors()
   {
      return m_BumpMapcolors;
   }

   public Primitive(Vector3[] vertecies, float kD, float kS, String texture, String bumpMap)
   {
      m_vertecies = vertecies.clone();
      m_originalVertecies = vertecies.clone();
      m_kD = kD;
      m_kS = kS;

      try
      {
         m_image = ImageIO.read(new File(texture));
         m_BumpMap = ImageIO.read(new File(bumpMap));
      } catch (IOException ex)
      {
         Logger.getLogger(Primitive.class.getName()).log(Level.SEVERE, null, ex);
      }

      m_Texturecolors = getRGB(getImage(texture));
      m_BumpMapcolors = getRGB(getImage(bumpMap));
   }

   public void draw(Graphics g, boolean scanlineActivated)
   {
      g.setColor(m_color);
      if (!scanlineActivated)
      {
         for (int i = 0; i < m_vertecies.length; i++)
         {
            if (i == m_vertecies.length - 1)
            {
               g.drawLine((int) m_vertecies[m_vertecies.length - 1].GetX(), (int) m_vertecies[m_vertecies.length - 1].GetY(), (int) m_vertecies[0].GetX(), (int) m_vertecies[0].GetY());
               //g.drawString("V:" + i + "(" + m_vertecies[i].GetX() + "," + m_vertecies[i].GetY() + "," + m_vertecies[i].GetZ() + ")", (int) m_vertecies[i].GetX(), (int) m_vertecies[i].GetY());
            }
            else
            {
               g.drawLine((int) m_vertecies[i].GetX(), (int) m_vertecies[i].GetY(), (int) m_vertecies[i + 1].GetX(), (int) m_vertecies[i + 1].GetY());

               //g.drawString("V:" + i + "(" + m_vertecies[i].GetX() + "," + m_vertecies[i].GetY() + "," + m_vertecies[i].GetZ() + ")", (int) m_vertecies[i].GetX(), (int) m_vertecies[i].GetY());
            }
         }
      }

      if (m_isSelected)
      {
         g.drawString("SP", (int) m_vertecies[0].GetX(), (int) m_vertecies[0].GetY());
         g.drawString("SP", (int) m_vertecies[1].GetX(), (int) m_vertecies[1].GetY());
         g.drawString("SP", (int) m_vertecies[2].GetX(), (int) m_vertecies[2].GetY());
         g.drawString("SP", (int) m_vertecies[3].GetX(), (int) m_vertecies[3].GetY());
      }
   }

   public void reset()
   {
      m_vertecies = m_originalVertecies.clone();
   }

   public ArrayList<Edge> getEdges(boolean setTextureInfo)
   {
      if (setTextureInfo)
      {
         setTextureCoordinates();
      }

      for (int i = 0; i < m_vertecies.length; i++)
      {
         m_edges.add(new Edge());

         if (i == m_vertecies.length - 1)
         {
            //Y-MIN
            if (m_vertecies[i].GetY() < m_vertecies[0].GetY())
            {
               m_edges.get(i).setYmin(m_vertecies[i].GetY());
            }
            else
            {
               m_edges.get(i).setYmin(m_vertecies[0].GetY());
            }

            //Y-MAX
            if (m_vertecies[i].GetY() > m_vertecies[0].GetY())
            {
               m_edges.get(i).setYmax(m_vertecies[i].GetY());
            }
            else
            {
               m_edges.get(i).setYmax(m_vertecies[0].GetY());
            }

            //X-MIN
            if (m_vertecies[i].GetY() < m_vertecies[0].GetY())
            {
               m_edges.get(i).setXmin(m_vertecies[i].GetX());
            }
            else
            {
               m_edges.get(i).setXmin(m_vertecies[0].GetX());
            }

            //1/m
            if (m_vertecies[i].GetY() <= m_vertecies[0].GetY())
            {
               m_edges.get(i).setInverseSlope(1 / DrawApplication.g_MY_MATH_LIB.getSlope(m_vertecies[0], m_vertecies[i]));
            }
            else
            {
               m_edges.get(i).setInverseSlope(1 / DrawApplication.g_MY_MATH_LIB.getSlope(m_vertecies[i], m_vertecies[0]));
            }
         }
         else
         {
            //Y-MIN
            if (m_vertecies[i].GetY() < m_vertecies[i + 1].GetY())
            {
               m_edges.get(i).setYmin(m_vertecies[i].GetY());
            }
            else
            {
               m_edges.get(i).setYmin(m_vertecies[i + 1].GetY());
            }

            //Y-MAX
            if (m_vertecies[i].GetY() > m_vertecies[i + 1].GetY())
            {
               m_edges.get(i).setYmax(m_vertecies[i].GetY());
            }
            else
            {
               m_edges.get(i).setYmax(m_vertecies[i + 1].GetY());
            }

            //X-MIN
            if (m_vertecies[i].GetY() < m_vertecies[i + 1].GetY())
            {
               m_edges.get(i).setXmin(m_vertecies[i].GetX());
            }
            else
            {
               m_edges.get(i).setXmin(m_vertecies[i + 1].GetX());
            }

            //1/m
            if (m_vertecies[i].GetY() <= m_vertecies[i + 1].GetY())
            {
               m_edges.get(i).setInverseSlope(1 / DrawApplication.g_MY_MATH_LIB.getSlope(m_vertecies[i], m_vertecies[i + 1]));
            }
            else
            {
               m_edges.get(i).setInverseSlope(1 / DrawApplication.g_MY_MATH_LIB.getSlope(m_vertecies[i + 1], m_vertecies[i]));
            }
         }
      }

      setEdgePointsXY();

      setTexturePoints();

      setStepSizes();

      setPlaneNormal(m_vertecies[1], m_vertecies[2], m_vertecies[0]);

      return m_edges;
   }

   private void setTextureCoordinates()
   {
      m_vertecies[0].setXMapCoord(0);
      m_vertecies[0].setYMapCoord(0);

      m_vertecies[1].setXMapCoord(m_image.getWidth());
      m_vertecies[1].setYMapCoord(0);

      m_vertecies[2].setXMapCoord(m_image.getWidth());
      m_vertecies[2].setYMapCoord(m_image.getHeight());

      m_vertecies[3].setXMapCoord(0);
      m_vertecies[3].setYMapCoord(m_image.getHeight());
   }

   private void setEdgePointsXY()
   {
      for (int i = 0; i < m_vertecies.length; i++)
      {
         if (i == m_vertecies.length - 1)
         {
            if (m_vertecies[i].GetY() <= m_vertecies[0].GetY())// && m_vertecies[i].GetX() <= m_vertecies[0].GetX())
            {
               m_edges.get(i).getPointOne().SetX(m_vertecies[i].GetX());
               m_edges.get(i).getPointOne().SetY(m_vertecies[i].GetY());
               m_edges.get(i).getPointOne().SetZ(m_vertecies[i].GetZ());
               m_edges.get(i).getPointTwo().SetX(m_vertecies[0].GetX());
               m_edges.get(i).getPointTwo().SetY(m_vertecies[0].GetY());
               m_edges.get(i).getPointTwo().SetZ(m_vertecies[0].GetZ());
            }
            else
            {
               m_edges.get(i).getPointOne().SetX(m_vertecies[0].GetX());
               m_edges.get(i).getPointOne().SetY(m_vertecies[0].GetY());
               m_edges.get(i).getPointOne().SetZ(m_vertecies[0].GetZ());
               m_edges.get(i).getPointTwo().SetX(m_vertecies[i].GetX());
               m_edges.get(i).getPointTwo().SetY(m_vertecies[i].GetY());
               m_edges.get(i).getPointTwo().SetZ(m_vertecies[i].GetZ());
            }
         }
         else
         {
            if (m_vertecies[i].GetY() <= m_vertecies[i + 1].GetY())// && m_vertecies[i].GetX() <= m_vertecies[i + 1].GetX())
            {
               m_edges.get(i).getPointOne().SetX(m_vertecies[i].GetX());
               m_edges.get(i).getPointOne().SetY(m_vertecies[i].GetY());
               m_edges.get(i).getPointOne().SetZ(m_vertecies[i].GetZ());
               m_edges.get(i).getPointTwo().SetX(m_vertecies[i + 1].GetX());
               m_edges.get(i).getPointTwo().SetY(m_vertecies[i + 1].GetY());
               m_edges.get(i).getPointTwo().SetZ(m_vertecies[i + 1].GetZ());
            }
            else
            {
               m_edges.get(i).getPointOne().SetX(m_vertecies[i + 1].GetX());
               m_edges.get(i).getPointOne().SetY(m_vertecies[i + 1].GetY());
               m_edges.get(i).getPointOne().SetZ(m_vertecies[i + 1].GetZ());
               m_edges.get(i).getPointTwo().SetX(m_vertecies[i].GetX());
               m_edges.get(i).getPointTwo().SetY(m_vertecies[i].GetY());
               m_edges.get(i).getPointTwo().SetZ(m_vertecies[i].GetZ());
            }
         }
      }
   }

   private void setTexturePoints()
   {
      for (int i = 0; i < m_vertecies.length; i++)
      {
         if (i == m_vertecies.length - 1)
         {
            if (m_vertecies[i].GetY() <= m_vertecies[0].GetY())
            {
               m_edges.get(i).getPointOne().setXMapCoord(m_vertecies[i].getXMapCoord());
               m_edges.get(i).getPointOne().setYMapCoord(m_vertecies[i].getYMapCoord());

               m_edges.get(i).getPointTwo().setXMapCoord(m_vertecies[0].getXMapCoord());
               m_edges.get(i).getPointTwo().setYMapCoord(m_vertecies[0].getYMapCoord());
            }
            else
            {
               m_edges.get(i).getPointOne().setXMapCoord(m_vertecies[0].getXMapCoord());
               m_edges.get(i).getPointOne().setYMapCoord(m_vertecies[0].getYMapCoord());

               m_edges.get(i).getPointTwo().setXMapCoord(m_vertecies[i].getXMapCoord());
               m_edges.get(i).getPointTwo().setYMapCoord(m_vertecies[i].getYMapCoord());
            }
         }
         else
         {
            if (m_vertecies[i].GetY() <= m_vertecies[i + 1].GetY())
            {
               m_edges.get(i).getPointOne().setXMapCoord(m_vertecies[i].getXMapCoord());
               m_edges.get(i).getPointOne().setYMapCoord(m_vertecies[i].getYMapCoord());

               m_edges.get(i).getPointTwo().setXMapCoord(m_vertecies[i + 1].getXMapCoord());
               m_edges.get(i).getPointTwo().setYMapCoord(m_vertecies[i + 1].getYMapCoord());
            }
            else
            {
               m_edges.get(i).getPointOne().setXMapCoord(m_vertecies[i + 1].getXMapCoord());
               m_edges.get(i).getPointOne().setYMapCoord(m_vertecies[i + 1].getYMapCoord());

               m_edges.get(i).getPointTwo().setXMapCoord(m_vertecies[i].getXMapCoord());
               m_edges.get(i).getPointTwo().setYMapCoord(m_vertecies[i].getYMapCoord());
            }
         }
      }
   }

   private void setStepSizes()
   {
      for (int i = 0; i < m_vertecies.length; i++)
      {
         if (m_edges.get(i).getPointOne().GetY() <= m_edges.get(i).getPointTwo().GetY())
         {
            m_edges.get(i).setXStepSize((m_edges.get(i).getPointTwo().getXMapCoord() - m_edges.get(i).getPointOne().getXMapCoord()) / (m_edges.get(i).getYmax() - m_edges.get(i).getYmin()));
            m_edges.get(i).setYStepSize((m_edges.get(i).getPointTwo().getYMapCoord() - m_edges.get(i).getPointOne().getYMapCoord()) / (m_edges.get(i).getYmax() - m_edges.get(i).getYmin()));

            m_edges.get(i).setZStepSize((m_edges.get(i).getPointTwo().GetZ() - m_edges.get(i).getPointOne().GetZ()) / (m_edges.get(i).getYmax() - m_edges.get(i).getYmin()));
         }
         else
         {
            m_edges.get(i).setXStepSize((m_edges.get(i).getPointOne().getXMapCoord() - m_edges.get(i).getPointTwo().getXMapCoord()) / (m_edges.get(i).getYmin() - m_edges.get(i).getYmax()));
            m_edges.get(i).setYStepSize((m_edges.get(i).getPointOne().getYMapCoord() - m_edges.get(i).getPointTwo().getYMapCoord()) / (m_edges.get(i).getYmin() - m_edges.get(i).getYmax()));

            m_edges.get(i).setZStepSize((m_edges.get(i).getPointOne().GetZ() - m_edges.get(i).getPointTwo().GetZ()) / (m_edges.get(i).getYmin() - m_edges.get(i).getYmax()));
         }
      }
   }

   private void setPlaneNormal(Vector3 edgePoint, Vector3 edgeA, Vector3 edgeB)
   {
      m_planeNormal = DrawApplication.g_MY_MATH_LIB.getPlaneNormal(edgePoint, edgeA, edgeB);
   }

   public static BufferedImage getImage(String imageName)
   {
      try
      {
         File input = new File(imageName);
         BufferedImage image = ImageIO.read(input);
         return image;
      } catch (IOException ie)
      {
         System.out.println("Error:" + ie.getMessage());
      }
      return null;
   }

   public static int[][] getRGB(BufferedImage img)
   {
      int w1 = img.getWidth();
      int h1 = img.getHeight();
      int colors[][] = new int[w1][h1];
      for (int i = 0; i < w1; i++)
      {
         for (int j = 0; j < h1; j++)
         {
            colors[i][j] = img.getRGB(i, j); // store value
         }
      }
      return colors;
   }
}
