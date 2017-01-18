/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.*;

/**
 *
 * @author DI
 */
public class Scanline
{
   private Primitive m_primitive;
   private ArrayList<Edge> m_allEdges = new ArrayList<Edge>();
   private ArrayList<Edge> m_globalEdges = new ArrayList<Edge>();
   private ArrayList<Edge> m_activeEdges = new ArrayList<Edge>();
   private BufferedImage m_bImg;
   private int m_scanline;
   private float m_distanceConstant = 0.01f;
   private float m_ambientLight = 0.01f;
   private int m_specularReflectionHighligh = 1;
   private ArrayList<Light> m_lights;
   private ArrayList<Primitive> m_primitives;
   private Vector3 m_viewPoint;

   public Scanline()
   {
   }

   public void performScan(Graphics g, ImageObserver obs, Vector3 viewPoint, ArrayList<Primitive> primitives, ArrayList<Light> lights, float ambientLight, float distanceConstant, int specRefHighlights, boolean drawTexture, boolean showBumpMap, boolean lightsOnOff)
   {
      m_primitives = primitives;
      m_lights = lights;
      m_ambientLight = ambientLight;
      m_distanceConstant = distanceConstant;
      m_specularReflectionHighligh = specRefHighlights;
      m_viewPoint = viewPoint;


      for (Primitive polygon : m_primitives)
      {
         m_bImg = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);

         m_primitive = polygon;

         reset(drawTexture);

         do
         {
            setActiveEdges(m_scanline);
            checkActiveEdges(m_scanline);
            for (int i = 0; i < m_activeEdges.size() - 1; i += 2)
            {
               setPixels(m_activeEdges.get(i), m_activeEdges.get(i + 1), drawTexture, showBumpMap, lightsOnOff);
            }

            updateActiveEdges();
            m_scanline++;
         } while (m_activeEdges.size() > 0 || m_globalEdges.size() > 0);

         g.drawImage(m_bImg, 0, 0, obs);

         reset(drawTexture);
      }
   }

   private void reset(boolean setTextureInfo)
   {
      m_allEdges.clear();
      m_globalEdges.clear();
      m_activeEdges.clear();
      m_allEdges = m_primitive.getEdges(setTextureInfo);
      setGlobalEdges();
   }

   public void setPixels(Edge edge1, Edge edge2, boolean textureOnOff, boolean bumpMapOnOff, boolean lightsOnOff)
   {
      Color polygonTexturecolor;

      float zStepSize = (edge2.getZval() - edge1.getZval()) / (edge2.getXmin() - edge1.getXmin());

      float ScanlineZ = edge1.getPointOne().GetZ();

      float scanLineX = (edge2.getPointOne().getXMapCoord() - edge1.getPointOne().getXMapCoord()) / (edge2.getXmin() - edge1.getXmin());
      float scanLineY = (edge2.getPointOne().getYMapCoord() - edge1.getPointOne().getYMapCoord()) / (edge2.getXmin() - edge1.getXmin());

      float u = edge1.getPointOne().getXMapCoord();
      float v = edge1.getPointOne().getYMapCoord();

      float intensity = 1f;

      for (int x = (int) edge1.getXmin(); x < (int) edge2.getXmin(); x++)
      {
         intensity = 0;

         if (textureOnOff)
         {
            if (u >= m_primitive.getImage().getWidth())
            {
               u = m_primitive.getImage().getWidth() - 1;
            }

            if (v >= m_primitive.getImage().getHeight())
            {
               v = m_primitive.getImage().getHeight() - 1;
            }

            if (bumpMapOnOff && lightsOnOff)
            {
               Color bumpMapColors = new Color(m_primitive.getBumpMapColors()[(int) u][(int) v]);



               for (Light light : m_lights)
               {
                  intensity += light.getIntensity(m_primitive, new Vector3(x, m_scanline, ScanlineZ), m_viewPoint, m_specularReflectionHighligh, bumpMapColors);
               }
               intensity = (intensity / m_distanceConstant) + m_ambientLight;
            }
            else
            {
               if (lightsOnOff)
               {
                  for (Light light : m_lights)
                  {
                     intensity += light.getIntensity(m_primitive, new Vector3(x, m_scanline, ScanlineZ), m_viewPoint, m_specularReflectionHighligh);
                  }

                  intensity = (intensity / m_distanceConstant) + m_ambientLight;
               }
            }

            polygonTexturecolor = new Color(m_primitive.getTextureColors()[(int) u][(int) v]);

            polygonTexturecolor = setNewColor(polygonTexturecolor, intensity);

            try
            {
               m_bImg.setRGB(x, m_scanline, polygonTexturecolor.getRGB());
            } catch (Exception e)
            {
            }
         }
         else
         {
            if (u >= m_primitive.getImage().getWidth())
            {
               u = m_primitive.getImage().getWidth() - 1;
            }

            if (v >= m_primitive.getImage().getHeight())
            {
               v = m_primitive.getImage().getHeight() - 1;
            }
            
            if (lightsOnOff)
            {
               if (bumpMapOnOff)
               {
                  Color bumpMapColors = new Color(m_primitive.getBumpMapColors()[(int) u][(int) v]);
                  for (Light light : m_lights)
                  {
                     intensity += light.getIntensity(m_primitive, new Vector3(x, m_scanline, ScanlineZ), m_viewPoint, m_specularReflectionHighligh, bumpMapColors);
                  }
               }
               else
               {
                  for (Light light : m_lights)
                  {
                     intensity += light.getIntensity(m_primitive, new Vector3(x, m_scanline, ScanlineZ), m_viewPoint, m_specularReflectionHighligh);
                  }

               }

               intensity = (intensity / m_distanceConstant) + m_ambientLight;
            }

            Color col = new Color(m_primitive.getColor().getRGB());
            col = setNewColor(col, intensity);

            try
            {
               m_bImg.setRGB(x, m_scanline, col.getRGB());
            } catch (Exception e)
            {
            }
         }

         u += scanLineX;
         v += scanLineY;
         ScanlineZ += zStepSize;
      }
   }

   private Color setNewColor(Color color, float intensity)
   {
      int red = (int) (color.getRed() * intensity);
      if (red >= 255)
      {
         red = 255;
      }
      else if (red <= 0)
      {
         red = 0;
      }

      int green = (int) (color.getGreen() * intensity);
      if (green >= 255)
      {
         green = 255;
      }
      else if (green <= 0)
      {
         green = 0;
      }

      int blue = (int) (color.getBlue() * intensity);
      if (blue >= 255)
      {
         blue = 255;
      }
      else if (blue <= 0)
      {
         blue = 0;
      }

      int alpha = (int) (color.getAlpha());

      return new Color(red, green, blue, alpha);
   }

   private void setGlobalEdges()
   {
      for (int i = 0; i < m_allEdges.size(); i++)
      {
         if (!Float.isInfinite(m_allEdges.get(i).getInverseSlope()))
         {
            m_globalEdges.add(m_allEdges.get(i));
         }
      }
      sortGlobalEdges();
   }

   private void sortGlobalEdges()
   {
      Edge dummy;

      for (int i = 0; i < m_globalEdges.size(); i++)
      {
         for (int j = 1; j < (m_globalEdges.size() - i); j++)
         {
            if (m_globalEdges.get(j - 1).getYmin() > m_globalEdges.get(j).getYmin())
            {
               dummy = m_globalEdges.get(j - 1);
               m_globalEdges.set(j - 1, m_globalEdges.get(j));
               m_globalEdges.set(j, dummy);
            }
         }
      }

      m_scanline = (int) m_globalEdges.get(0).getYmin();
   }

   private void setActiveEdges(int y)
   {
      for (int i = 0; i < m_globalEdges.size(); i++)
      {
         if ((int) (m_globalEdges.get(i).getYmin()) == y)
         {
            m_activeEdges.add(m_globalEdges.get(i));
            m_globalEdges.remove(i);
            i--;
         }
      }

      sortActiveEdges();
   }

   private void checkActiveEdges(int y)
   {
      for (int i = 0; i < m_activeEdges.size(); i++)
      {
         if ((int) (m_activeEdges.get(i).getYmax()) == y)
         {
            m_activeEdges.remove(i);
            i--;
         }
      }
   }

   private void sortActiveEdges()
   {
      Edge dummy;

      for (int i = 0; i < m_activeEdges.size(); i++)
      {
         for (int j = 1; j < (m_activeEdges.size() - i); j++)
         {
            if (m_activeEdges.get(j - 1).getXmin() > m_activeEdges.get(j).getXmin())
            {
               dummy = m_activeEdges.get(j - 1);
               m_activeEdges.set(j - 1, m_activeEdges.get(j));
               m_activeEdges.set(j, dummy);
            }
         }
      }
   }

   private void updateActiveEdges()
   {
      for (Edge edge : m_activeEdges)
      {
         edge.setXmin(edge.getXmin() + edge.getInverseSlope());

         edge.getPointOne().setXMapCoord(edge.getPointOne().getXMapCoord()+ edge.getXStepSize());
         edge.getPointOne().setYMapCoord(edge.getPointOne().getYMapCoord() + edge.getYStepSize());
         edge.setZval(edge.getPointOne().GetZ() + edge.getZStepSize());
      }
      sortActiveEdges();
   }
}
