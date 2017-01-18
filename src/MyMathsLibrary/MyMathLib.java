/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyMathsLibrary;

import Framework.Vector3;

/*@author DI*/
public class MyMathLib
{
   public float getSlope(Vector3 a, Vector3 b)
   {
      float a1 = b.GetY() - a.GetY();
      float a2 = b.GetX() - a.GetX();
      float ab = a1 / a2;

      return ab;
   }

   public Vector3 getVector(Vector3 a, Vector3 b)
   {
      return new Vector3((b.GetX() - a.GetX()), (b.GetY() - a.GetY()), (b.GetZ() - a.GetZ()));
   }

   public Vector3 addVectors(Vector3 v1, Vector3 v2)
   {
      return new Vector3(v1.GetX() + v2.GetX(), v1.GetY() + v2.GetY(), v1.GetZ() + v2.GetZ());
   }

   public Vector3 subtractVectors(Vector3 v1, Vector3 v2)
   {
      return new Vector3(v1.GetX() - v2.GetX(), v1.GetY() - v2.GetY(), v1.GetZ() - v2.GetZ());
   }

   public float getDotProduct(Vector3 a, Vector3 b)
   {
      a = a.Normalize();
      b = b.Normalize();

      return (float) ((a.GetX() * b.GetX()) + (a.GetY() * b.GetY()) + (a.GetZ() * b.GetZ()));
   }

   public float getVectorLenght(Vector3 vector)
   {
      return (float) Math.sqrt((Math.pow(vector.GetX(), 2)) + (Math.pow(vector.GetY(), 2)) + (Math.pow(vector.GetZ(), 2)));
   }

   public Vector3 getCrossProduct(Vector3 a, Vector3 b)
   {
      Vector3 crossProd = new Vector3((a.GetY() * b.GetZ()) - (a.GetZ() * b.GetY()),
              (a.GetZ() * b.GetX()) - (a.GetX() * b.GetZ()),
              (a.GetX() * b.GetY()) - (a.GetY() * b.GetX()));

      crossProd = crossProd.Normalize();

      return crossProd;
   }

   public Vector3 getPlaneNormal(Vector3 point, Vector3 pointA, Vector3 pointB)
   {
      Vector3 a = getVector(pointA, point);
      Vector3 b = getVector(pointB, point);

      Vector3 normal = getCrossProduct(a, b);

      return normal;
   }

   public Vector3 multiplyVectors(Vector3 a, Vector3 b)
   {
      return new Vector3((a.GetX() * b.GetX()), (a.GetY() * b.GetY()), (a.GetZ() * b.GetZ()));
   }

   public float[][] multiplyMatrices(float[][] matrix1, float[][] matrix2)
   {
      float[][] matrix = new float[matrix1.length][matrix1.length];

      for (int i = 0; i < matrix1.length; i++)
      {
         for (int j = 0; j < matrix1.length; j++)
         {
            for (int k = 0; k < matrix1.length; k++)
            {
               matrix[i][k] += matrix1[i][j] * matrix2[j][k];
            }
         }
      }

      return matrix;
   }

   public Vector3 multiplyVector3WithMatrix4by4(Vector3 vector, float[][] matrix)
   {
      Vector3 vector1 = new Vector3();

      vector1.SetX((vector.GetX() * matrix[0][0])
              + (vector.GetY() * matrix[1][0])
              + (vector.GetZ() * matrix[2][0])
              + (matrix[3][0]));

      vector1.SetY((vector.GetX() * matrix[0][1])
              + (vector.GetY() * matrix[1][1])
              + (vector.GetZ() * matrix[2][1])
              + (matrix[3][1]));

      vector1.SetZ((vector.GetX() * matrix[0][2])
              + (vector.GetY() * matrix[1][2])
              + (vector.GetZ() * matrix[2][2])
              + (matrix[3][2]));

      return vector1;
   }

   public void printMatrix(float[][] Matrix)
   {
      for (int i = 0; i < 4; i++)
      {
         for (int j = 0; j < 4; j++)
         {
            System.out.print(Matrix[i][j] + ",");
         }
         System.out.println();
      }
   }

//---------------------------------2D TRANSFORMATIONS---------------------------------------------    
   private float[][] scalingMatrixT(float scaleX, float scaleY, float cX, float cY)
   {
      float[][] scalingMatrix = new float[3][3];

      scalingMatrix[0][0] = scaleX;
      scalingMatrix[0][1] = 0;
      scalingMatrix[0][2] = 0;

      scalingMatrix[1][0] = 0;
      scalingMatrix[1][1] = scaleY;
      scalingMatrix[1][2] = 0;

      scalingMatrix[2][0] = (cX * (1 - scaleX));
      scalingMatrix[2][1] = (cY * (1 - scaleY));
      scalingMatrix[2][2] = 1;

      return scalingMatrix;
   }

   private float[][] scalingMatrix(float scaleX, float scaleY)
   {
      float[][] scalingMatrix = new float[3][3];

      scalingMatrix[0][0] = scaleX;
      scalingMatrix[0][1] = 0;
      scalingMatrix[0][2] = 0;

      scalingMatrix[1][0] = 0;
      scalingMatrix[1][1] = scaleY;
      scalingMatrix[1][2] = 0;

      scalingMatrix[2][0] = 0;
      scalingMatrix[2][1] = 0;
      scalingMatrix[2][2] = 1;

      return scalingMatrix;
   }

   private float[][] scale(Vector3 vector, float[][] scalingMatrix)
   {
      float[][] scaledMatrix = new float[1][3];

      scaledMatrix[0][0] = (vector.GetX() * scalingMatrix[0][0])
              + (vector.GetY() * scalingMatrix[1][0])
              + (vector.GetZ() * scalingMatrix[2][0]);

      scaledMatrix[0][1] = (vector.GetX() * scalingMatrix[0][1])
              + (vector.GetY() * scalingMatrix[1][1])
              + (vector.GetZ() * scalingMatrix[2][1]);

      scaledMatrix[0][2] = (vector.GetX() * scalingMatrix[0][2])
              + (vector.GetY() * scalingMatrix[1][2])
              + (vector.GetZ() * scalingMatrix[2][2]);

      return scaledMatrix;
   }

   private float[][] rotationMatrixT(float degree, float cX, float cY)
   {
      float[][] rotationMatrix = new float[3][3];

      rotationMatrix[0][0] = (float) Math.cos(Math.toRadians(degree));
      rotationMatrix[0][1] = (float) Math.sin(Math.toRadians(degree));
      rotationMatrix[0][2] = 0;

      rotationMatrix[1][0] = (float) Math.sin(Math.toRadians(-degree));
      rotationMatrix[1][1] = (float) Math.cos(Math.toRadians(degree));
      rotationMatrix[1][2] = 0;

      rotationMatrix[2][0] = (cX * (1 - (float) Math.cos(Math.toRadians(degree))))
              + (cY * ((float) Math.sin(Math.toRadians(degree))));
      rotationMatrix[2][1] = (cY * (1 - (float) Math.cos(Math.toRadians(degree))))
              - (cX * ((float) Math.sin(Math.toRadians(degree))));
      rotationMatrix[2][2] = 1;

      return rotationMatrix;
   }

   private float[][] rotationMatrix(float degree)
   {
      float[][] rotationMatrix = new float[3][3];

      rotationMatrix[0][0] = (float) Math.cos(Math.toRadians(degree));
      rotationMatrix[0][1] = (float) Math.sin(Math.toRadians(degree));
      rotationMatrix[0][2] = 0;

      rotationMatrix[1][0] = (float) Math.sin(Math.toRadians(-degree));
      rotationMatrix[1][1] = (float) Math.cos(Math.toRadians(degree));
      rotationMatrix[1][2] = 0;

      rotationMatrix[2][0] = 0;
      rotationMatrix[2][1] = 0;
      rotationMatrix[2][2] = 1;

      return rotationMatrix;
   }

   private float[][] rotate(Vector3 vector, float[][] rotationMatrix)
   {
      float[][] rotatedMatrix = new float[1][3];
      rotatedMatrix[0][0] = (vector.GetX() * rotationMatrix[0][0]) + (vector.GetY() * rotationMatrix[1][0]) + (vector.GetZ() * rotationMatrix[2][0]);

      rotatedMatrix[0][1] = (vector.GetX() * rotationMatrix[0][1]) + (vector.GetY() * rotationMatrix[1][1]) + (vector.GetZ() * rotationMatrix[2][1]);

      rotatedMatrix[0][2] = (vector.GetX() * rotationMatrix[0][2]) + (vector.GetY() * rotationMatrix[1][2]) + (vector.GetZ() * rotationMatrix[2][2]);

      return rotatedMatrix;
   }

   private float[][] scaleRotateMatrix(float sX, float sY, float degree, float cX, float cY)
   {
      float[][] matrix = new float[3][3];

      matrix[0][0] = sX * (float) Math.cos(Math.toRadians(degree));
      matrix[0][1] = 0;
      matrix[0][2] = 0;

      matrix[1][0] = 0;
      matrix[1][1] = sY * (float) Math.cos(Math.toRadians(degree));
      matrix[1][2] = 0;

      matrix[2][0] = (cX * (1 - sX * (float) Math.cos(Math.toRadians(degree)))) + (-cY * sY * (float) Math.sin(Math.toRadians(-degree)));

      matrix[2][1] = (-cX * sX * (float) Math.sin(Math.toRadians(degree))) + (cY * (1 - sY * (float) Math.cos(Math.toRadians(degree))));

      matrix[2][2] = 1;

      return matrix;
   }

   private float[][] scaleRotate(Vector3 vector, float[][] matrix)
   {
      float[][] scaleRotateMatrix = new float[1][3];

      scaleRotateMatrix[0][0] = (vector.GetX() * matrix[0][0]) + (vector.GetY() * matrix[1][0]) + (matrix[2][0]);

      scaleRotateMatrix[0][1] = (vector.GetX() * matrix[0][1]) + (vector.GetY() * matrix[1][1]) + (matrix[2][1]);

      scaleRotateMatrix[0][2] = (vector.GetX() * matrix[0][2]) + (vector.GetY() * matrix[1][2]) + (matrix[2][2]);

      return scaleRotateMatrix;
   }

   public Vector3 transform(Vector3 vector, float degree, float cX, float cY)
   {
      float[][] rotationMatrix = rotate(vector, rotationMatrixT(degree, cX, cY));

      return new Vector3(rotationMatrix[0][0], rotationMatrix[0][1], rotationMatrix[0][2]);
   }

   public Vector3 transform(Vector3 vector, float degree)
   {
      float[][] rotationMatrix = rotate(vector, rotationMatrix(degree));

      return new Vector3(rotationMatrix[0][0], rotationMatrix[0][1], rotationMatrix[0][2]);
   }

   public Vector3 transform(Vector3 vector, float scaleX, float scaleY, float cX, float cY)
   {
      float[][] scalingMatrix = scale(vector, scalingMatrixT(scaleX, scaleY, cX, cY));

      return new Vector3(scalingMatrix[0][0], scalingMatrix[0][1], scalingMatrix[0][2]);
   }

   public Vector3 transform(Vector3 vector, float scaleX, float scaleY)
   {
      float[][] scalingMatrix = scale(vector, scalingMatrix(scaleX, scaleY));

      return new Vector3(scalingMatrix[0][0], scalingMatrix[0][1], scalingMatrix[0][2]);
   }

   public Vector3 transform(Vector3 vector, float scaleX, float scaleY, float degree, float cX, float cY)
   {
      float[][] scaleRotate = scaleRotate(vector, scaleRotateMatrix(scaleX, scaleY, degree, cX, cY));

      return new Vector3(scaleRotate[0][0], scaleRotate[0][1], scaleRotate[0][2]);
   }

//-----------------------------------------3D TRANSFORMATIONS-----------------------------------------------------    
   private float[][] translationMatrix(float x, float y, float z)
   {
      float[][] matrix = new float[4][4];

      matrix[0][0] = 1;
      matrix[0][1] = 0;
      matrix[0][2] = 0;
      matrix[0][3] = 0;

      matrix[1][0] = 0;
      matrix[1][1] = 1;
      matrix[1][2] = 0;
      matrix[1][3] = 0;

      matrix[2][0] = 0;
      matrix[2][1] = 0;
      matrix[2][2] = 1;
      matrix[2][3] = 0;

      matrix[3][0] = x;
      matrix[3][1] = y;
      matrix[3][2] = z;
      matrix[3][3] = 1;

      return matrix;
   }

   public Vector3 Transalte(Vector3 v, float x, float y, float z)
   {
      Vector3 vector = multiplyVector3WithMatrix4by4(v, translationMatrix(x, y, z));

      return vector;
   }

   private float[][] scalingMatrix3DT(float scaleX, float scaleY, float scaleZ, float cX, float cY, float cZ)
   {
      float[][] scalingMatrix = new float[4][4];

      scalingMatrix[0][0] = scaleX;
      scalingMatrix[0][1] = 0;
      scalingMatrix[0][2] = 0;
      scalingMatrix[0][3] = 0;

      scalingMatrix[1][0] = 0;
      scalingMatrix[1][1] = scaleY;
      scalingMatrix[1][2] = 0;
      scalingMatrix[1][3] = 0;

      scalingMatrix[2][0] = 0;
      scalingMatrix[2][1] = 0;
      scalingMatrix[2][2] = scaleZ;
      scalingMatrix[2][3] = 0;

      scalingMatrix[3][0] = (cX * (1 - scaleX));
      scalingMatrix[3][1] = (cY * (1 - scaleY));
      scalingMatrix[3][2] = (cZ * (1 - scaleZ));
      scalingMatrix[3][3] = 1;

      return scalingMatrix;
   }

   private float[][] scalingMatrix3D(float scaleX, float scaleY, float scaleZ)
   {
      float[][] scalingMatrix = new float[4][4];

      scalingMatrix[0][0] = scaleX;
      scalingMatrix[0][1] = 0;
      scalingMatrix[0][2] = 0;
      scalingMatrix[0][3] = 0;

      scalingMatrix[1][0] = 0;
      scalingMatrix[1][1] = scaleY;
      scalingMatrix[1][2] = 0;
      scalingMatrix[1][3] = 0;

      scalingMatrix[2][0] = 0;
      scalingMatrix[2][1] = 0;
      scalingMatrix[2][2] = scaleZ;
      scalingMatrix[2][3] = 0;

      scalingMatrix[3][0] = 0;
      scalingMatrix[3][1] = 0;
      scalingMatrix[3][2] = 0;
      scalingMatrix[3][3] = 1;

      return scalingMatrix;
   }

   private float[][] scale3D(Vector3 vector, float[][] scalingMatrix)
   {
      float[][] scaledMatrix = new float[1][4];

      scaledMatrix[0][0] = (vector.GetX() * scalingMatrix[0][0]) + (vector.GetY() * scalingMatrix[1][0]) + (vector.GetZ() * scalingMatrix[2][0]) + (scalingMatrix[3][0]);

      scaledMatrix[0][1] = (vector.GetX() * scalingMatrix[0][1]) + (vector.GetY() * scalingMatrix[1][1]) + (vector.GetZ() * scalingMatrix[2][1]) + (scalingMatrix[3][1]);

      scaledMatrix[0][2] = (vector.GetX() * scalingMatrix[0][2]) + (vector.GetY() * scalingMatrix[1][2]) + (vector.GetZ() * scalingMatrix[2][2]) + (scalingMatrix[3][2]);

      scaledMatrix[0][3] = (vector.GetX() * scalingMatrix[0][3]) + (vector.GetY() * scalingMatrix[1][3]) + (vector.GetZ() * scalingMatrix[2][3]) + (scalingMatrix[3][3]);

      return scaledMatrix;
   }

   private float[][] rotationMatrix3DTX(float degree, float cX, float cY, float cZ)
   {
      float[][] rotationMatrix = new float[4][4];

      rotationMatrix[0][0] = 1;
      rotationMatrix[0][1] = 0;
      rotationMatrix[0][2] = 0;
      rotationMatrix[0][3] = 0;

      rotationMatrix[1][0] = 0;
      rotationMatrix[1][1] = (float) Math.cos(Math.toRadians(degree));
      rotationMatrix[1][2] = 0;
      rotationMatrix[1][3] = 0;

      rotationMatrix[2][0] = 0;
      rotationMatrix[2][1] = 0;
      rotationMatrix[2][2] = (float) Math.cos(Math.toRadians(degree));;
      rotationMatrix[2][3] = 0;

      rotationMatrix[3][0] = 0;
      rotationMatrix[3][1] = (cY * (1 - (float) Math.cos(Math.toRadians(degree)))) + (-cZ * ((float) Math.sin(Math.toRadians(-degree))));
      rotationMatrix[3][2] = (-cY * (float) Math.sin(Math.toRadians(degree))) + (cZ * (1 - ((float) Math.cos(Math.toRadians(degree)))));
      rotationMatrix[3][3] = 1;

      return rotationMatrix;
   }

   private float[][] rotationMatrix3DX(float degree)
   {
      float[][] rotationMatrix = new float[4][4];

      rotationMatrix[0][0] = 1;
      rotationMatrix[0][1] = 0;
      rotationMatrix[0][2] = 0;
      rotationMatrix[0][3] = 0;

      rotationMatrix[1][0] = 0;
      rotationMatrix[1][1] = (float) Math.cos(Math.toRadians(degree));
      rotationMatrix[1][2] = (float) Math.sin(Math.toRadians(degree));;
      rotationMatrix[1][3] = 0;

      rotationMatrix[2][0] = 0;
      rotationMatrix[2][1] = (float) Math.sin(Math.toRadians(-degree));;
      rotationMatrix[2][2] = (float) Math.cos(Math.toRadians(degree));;
      rotationMatrix[2][3] = 0;

      rotationMatrix[3][0] = 0;
      rotationMatrix[3][1] = 0;
      rotationMatrix[3][2] = 0;
      rotationMatrix[3][3] = 1;

      return rotationMatrix;
   }

   private float[][] rotationMatrix3DTY(float degree, float cX, float cY, float cZ)
   {
      float[][] rotationMatrix = new float[4][4];

      rotationMatrix[0][0] = (float) Math.cos(Math.toRadians(degree));
      rotationMatrix[0][1] = 0;
      rotationMatrix[0][2] = 0;
      rotationMatrix[0][3] = 0;

      rotationMatrix[1][0] = 0;
      rotationMatrix[1][1] = 1;
      rotationMatrix[1][2] = 0;
      rotationMatrix[1][3] = 0;

      rotationMatrix[2][0] = 0;
      rotationMatrix[2][1] = 0;
      rotationMatrix[2][2] = (float) Math.cos(Math.toRadians(degree));;
      rotationMatrix[2][3] = 0;

      rotationMatrix[3][0] = (-cZ * (float) Math.sin(Math.toRadians(-degree)));
      rotationMatrix[3][1] = 0;
      rotationMatrix[3][2] = (-cX * (float) Math.sin(Math.toRadians(-degree))) + (cZ * (1 - ((float) Math.cos(Math.toRadians(degree)))));
      rotationMatrix[3][3] = 1;

      return rotationMatrix;
   }

   private float[][] rotationMatrix3DY(float degree)
   {
      float[][] rotationMatrix = new float[4][4];

      rotationMatrix[0][0] = (float) Math.cos(Math.toRadians(degree));
      rotationMatrix[0][1] = 0;
      rotationMatrix[0][2] = (float) Math.sin(Math.toRadians(-degree));
      rotationMatrix[0][3] = 0;

      rotationMatrix[1][0] = 0;
      rotationMatrix[1][1] = 1;
      rotationMatrix[1][2] = 0;
      rotationMatrix[1][3] = 0;

      rotationMatrix[2][0] = (float) Math.sin(Math.toRadians(degree));
      rotationMatrix[2][1] = 0;
      rotationMatrix[2][2] = (float) Math.cos(Math.toRadians(degree));
      rotationMatrix[2][3] = 0;

      rotationMatrix[3][0] = 0;
      rotationMatrix[3][1] = 0;
      rotationMatrix[3][2] = 0;
      rotationMatrix[3][3] = 1;

      return rotationMatrix;
   }

   private float[][] rotationMatrix3DTZ(float degree, float cX, float cY, float cZ)
   {
      float[][] rotationMatrix = new float[4][4];

      rotationMatrix[0][0] = (float) Math.cos(Math.toRadians(degree));
      rotationMatrix[0][1] = 0;
      rotationMatrix[0][2] = 0;
      rotationMatrix[0][3] = 0;

      rotationMatrix[1][0] = 0;
      rotationMatrix[1][1] = (float) Math.cos(Math.toRadians(degree));
      rotationMatrix[1][2] = 0;
      rotationMatrix[1][3] = 0;

      rotationMatrix[2][0] = 0;
      rotationMatrix[2][1] = 0;
      rotationMatrix[2][2] = 1;
      rotationMatrix[2][3] = 0;

      rotationMatrix[3][0] = (cX * (1 - (float) Math.cos(Math.toRadians(degree)))) + (-cY * (float) Math.sin(Math.toRadians(-degree)));
      rotationMatrix[3][1] = (-cX * (float) Math.sin(Math.toRadians(degree))) + (cY * (1 - (float) Math.cos(Math.toRadians(degree))));
      rotationMatrix[3][2] = 0;
      rotationMatrix[3][3] = 1;

      return rotationMatrix;
   }

   private float[][] rotationMatrix3DZ(float degree)
   {
      float[][] rotationMatrix = new float[4][4];

      rotationMatrix[0][0] = (float) Math.cos(Math.toRadians(degree));
      rotationMatrix[0][1] = (float) Math.sin(Math.toRadians(degree));
      rotationMatrix[0][2] = 0;
      rotationMatrix[0][3] = 0;

      rotationMatrix[1][0] = (float) Math.sin(Math.toRadians(-degree));
      rotationMatrix[1][1] = (float) Math.cos(Math.toRadians(degree));
      rotationMatrix[1][2] = 0;
      rotationMatrix[1][3] = 0;

      rotationMatrix[2][0] = 0;
      rotationMatrix[2][1] = 0;
      rotationMatrix[2][2] = 1;
      rotationMatrix[2][3] = 0;

      rotationMatrix[3][0] = 0;
      rotationMatrix[3][1] = 0;
      rotationMatrix[3][2] = 0;
      rotationMatrix[3][3] = 1;

      return rotationMatrix;
   }

   private float[][] rotate3D(Vector3 vector, float[][] rotationMatrix)
   {
      float[][] rotatedMatrix = new float[1][4];

      rotatedMatrix[0][0] = (vector.GetX() * rotationMatrix[0][0]) + (vector.GetY() * rotationMatrix[1][0]) + (vector.GetZ() * rotationMatrix[2][0]) + (rotationMatrix[3][0]);

      rotatedMatrix[0][1] = (vector.GetX() * rotationMatrix[0][1]) + (vector.GetY() * rotationMatrix[1][1]) + (vector.GetZ() * rotationMatrix[2][1]) + (rotationMatrix[3][1]);

      rotatedMatrix[0][2] = (vector.GetX() * rotationMatrix[0][2]) + (vector.GetY() * rotationMatrix[1][2]) + (vector.GetZ() * rotationMatrix[2][2]) + (rotationMatrix[3][2]);

      rotatedMatrix[0][3] = (vector.GetX() * rotationMatrix[0][3]) + (vector.GetY() * rotationMatrix[1][3]) + (vector.GetZ() * rotationMatrix[2][3]) + (rotationMatrix[3][3]);

      return rotatedMatrix;
   }

   public Vector3 transform3DScale(Vector3 vector, float scaleX, float scaleY, float scaleZ, float cX, float cY, float cZ)
   {
      float[][] scalingMatrix = scale3D(vector, scalingMatrix3DT(scaleX, scaleY, scaleZ, cX, cY, cZ));

      return new Vector3(scalingMatrix[0][0], scalingMatrix[0][1], scalingMatrix[0][2]);
   }

   public Vector3 transform3DScale(Vector3 vector, float scaleX, float scaleY, float scaleZ)
   {
      float[][] scalingMatrix = scale3D(vector, scalingMatrix3D(scaleX, scaleY, scaleZ));

      return new Vector3(scalingMatrix[0][0], scalingMatrix[0][1], scalingMatrix[0][2]);
   }

   public Vector3 transform3DRotateX(Vector3 vector, float degree, float cX, float cY, float cZ)
   {
      float[][] rotationMatrix = rotate3D(vector, rotationMatrix3DTX(degree, cX, cY, cZ));

      return new Vector3(rotationMatrix[0][0], rotationMatrix[0][1], rotationMatrix[0][2]);
   }

   public Vector3 transform3DRotateX(Vector3 vector, float degree)
   {
      float[][] rotationMatrix = rotate3D(vector, rotationMatrix3DX(degree));

      return new Vector3(rotationMatrix[0][0], rotationMatrix[0][1], rotationMatrix[0][2]);
   }

   public Vector3 transform3DRotateY(Vector3 vector, float degree, float cX, float cY, float cZ)
   {
      float[][] rotationMatrix = rotate3D(vector, rotationMatrix3DTY(degree, cX, cY, cZ));

      return new Vector3(rotationMatrix[0][0], rotationMatrix[0][1], rotationMatrix[0][2]);
   }

   public Vector3 transform3DRotateY(Vector3 vector, float degree)
   {
      float[][] rotationMatrix = rotate3D(vector, rotationMatrix3DY(degree));

      return new Vector3(rotationMatrix[0][0], rotationMatrix[0][1], rotationMatrix[0][2]);
   }

   public Vector3 transform3DRotateZ(Vector3 vector, float degree, float cX, float cY, float cZ)
   {
      float[][] rotationMatrix = rotate3D(vector, rotationMatrix3DTZ(degree, cX, cY, cZ));

      return new Vector3(rotationMatrix[0][0], rotationMatrix[0][1], rotationMatrix[0][2]);
   }

   public Vector3 transform3DRotateZ(Vector3 vector, float degree)
   {
      float[][] rotationMatrix = rotate3D(vector, rotationMatrix3DZ(degree));

      return new Vector3(rotationMatrix[0][0], rotationMatrix[0][1], rotationMatrix[0][2]);
   }

//------------------------ARBITRARY POINT-------------------------------    
   //Step1
   private float[][] translationArbitraryMatrix(Vector3 vector)
   {
      float[][] matrix = new float[4][4];

      matrix[0][0] = 1;
      matrix[0][1] = 0;
      matrix[0][2] = 0;
      matrix[0][3] = 0;

      matrix[1][0] = 0;
      matrix[1][1] = 1;
      matrix[1][2] = 0;
      matrix[1][3] = 0;

      matrix[2][0] = 0;
      matrix[2][1] = 0;
      matrix[2][2] = 1;
      matrix[2][3] = 0;

      matrix[3][0] = -vector.GetX();
      matrix[3][1] = -vector.GetY();
      matrix[3][2] = -vector.GetZ();
      matrix[3][3] = 1;

      return matrix;
   }

   //Step2
   private float[][] rotateByThetaAngleMatrix(float cosT, float sinT)
   {
      float[][] matrix = new float[4][4];

      matrix[0][0] = 1;
      matrix[0][1] = 0;
      matrix[0][2] = 0;
      matrix[0][3] = 0;

      matrix[1][0] = 0;
      matrix[1][1] = cosT;
      matrix[1][2] = sinT;
      matrix[1][3] = 0;

      matrix[2][0] = 0;
      matrix[2][1] = -sinT;
      matrix[2][2] = cosT;
      matrix[2][3] = 0;

      matrix[3][0] = 0;
      matrix[3][1] = 0;
      matrix[3][2] = 0;
      matrix[3][3] = 1;

      return matrix;
   }

   //Step3
   private float[][] rotateByBetaAngleMatrix(float cosB, float sinB)
   {
      float[][] matrix = new float[4][4];

      matrix[0][0] = cosB;
      matrix[0][1] = 0;
      matrix[0][2] = -sinB;
      matrix[0][3] = 0;

      matrix[1][0] = 0;
      matrix[1][1] = 1;
      matrix[1][2] = 0;
      matrix[1][3] = 0;

      matrix[2][0] = sinB;;
      matrix[2][1] = 0;
      matrix[2][2] = cosB;
      matrix[2][3] = 0;

      matrix[3][0] = 0;
      matrix[3][1] = 0;
      matrix[3][2] = 0;
      matrix[3][3] = 1;

      return matrix;
   }

   //Step4 rotate by 3dx-axis
   //step5 roate by negative Beta about y-axis
   private float[][] rotateByNegativeBetaAngleMatrix(float cosB, float sinB)
   {
      float[][] matrix = new float[4][4];

      matrix[0][0] = cosB;
      matrix[0][1] = 0;
      matrix[0][2] = sinB;
      matrix[0][3] = 0;

      matrix[1][0] = 0;
      matrix[1][1] = 1;
      matrix[1][2] = 0;
      matrix[1][3] = 0;

      matrix[2][0] = -sinB;
      matrix[2][1] = 0;
      matrix[2][2] = cosB;
      matrix[2][3] = 0;

      matrix[3][0] = 0;
      matrix[3][1] = 0;
      matrix[3][2] = 0;
      matrix[3][3] = 1;

      return matrix;
   }

   //Step6 rotate about negative Theta about x-axis
   private float[][] rotateByNegativeThetaAngleMatrix(float cosT, float sinT)
   {
      float[][] matrix = new float[4][4];

      matrix[0][0] = 1;
      matrix[0][1] = 0;
      matrix[0][2] = 0;
      matrix[0][3] = 0;

      matrix[1][0] = 0;
      matrix[1][1] = cosT;
      matrix[1][2] = -sinT;
      matrix[1][3] = 0;

      matrix[2][0] = 0;
      matrix[2][1] = sinT;
      matrix[2][2] = cosT;
      matrix[2][3] = 0;

      matrix[3][0] = 0;
      matrix[3][1] = 0;
      matrix[3][2] = 0;
      matrix[3][3] = 1;

      return matrix;
   }

   //Step 7 translae back
   private float[][] translationBackArbitraryMatrix(Vector3 vector)
   {
      float[][] matrix = new float[4][4];

      matrix[0][0] = 1;
      matrix[0][1] = 0;
      matrix[0][2] = 0;
      matrix[0][3] = 0;

      matrix[1][0] = 0;
      matrix[1][1] = 1;
      matrix[1][2] = 0;
      matrix[1][3] = 0;

      matrix[2][0] = 0;
      matrix[2][1] = 0;
      matrix[2][2] = 1;
      matrix[2][3] = 0;

      matrix[3][0] = vector.GetX();
      matrix[3][1] = vector.GetY();
      matrix[3][2] = vector.GetZ();
      matrix[3][3] = 1;

      return matrix;
   }

   //FINAL MATRIX
   public float[][] rotateAroundArbitraryAxis(Vector3 p1, Vector3 p2, float degrees, boolean printSteps)
   {
      float s1 = (float) Math.sqrt(Math.pow(p2.GetY(), 2) + Math.pow(p2.GetZ(), 2));
      float s2 = (float) Math.sqrt(Math.pow(p2.GetX(), 2) + Math.pow(p2.GetY(), 2) + Math.pow(p2.GetZ(), 2));

      float cosT = (p2.GetZ() / s1);
      float sinT = (p2.GetY() / s1);

      float cosB = (p2.GetX() / s2);
      float sinB = (s1 / s2);

      if (s1 == 0)
      {
         cosT = 1;
         sinT = 0;
      }

      //step 1 translate p1
      float[][] translatedP1 = translationArbitraryMatrix(p1);
      if (printSteps)
      {
         System.out.println("Step1:");
         printMatrix(translatedP1);
      }

      //step2 rotate p2 by angle theta about x axis
      float[][] ThetaAngleMatrix = rotateByThetaAngleMatrix(cosT, sinT);
      if (printSteps)
      {
         System.out.println("\nStep2:");
         printMatrix(ThetaAngleMatrix);
      }

      //step 3 rotate by angle beta about y axis
      float[][] BetaAngleMatrix = rotateByBetaAngleMatrix(cosB, sinB);
      if (printSteps)
      {
         System.out.println("\nStep3:");
         printMatrix(BetaAngleMatrix);
      }

      //step4 rotate around x-axis
      float[][] rotationMatrixX = rotationMatrix3DX(degrees);
      if (printSteps)
      {
         System.out.println("\nStep4:");
         printMatrix(rotationMatrixX);
      }

      //step 5 rotate by -beta angle around y axis
      float[][] NegativeBetaAngleMatrix = rotateByNegativeBetaAngleMatrix(cosB, sinB);
      if (printSteps)
      {
         System.out.println("\nStep5:");
         printMatrix(NegativeBetaAngleMatrix);
      }

      //step 6 rotate by -theta angle about x axis
      float[][] NegativeThetaAngleMatrix = rotateByNegativeThetaAngleMatrix(cosT, sinT);
      if (printSteps)
      {
         System.out.println("\nStep6:");
         printMatrix(NegativeThetaAngleMatrix);
      }

      //step 7 translate back
      float[][] translatedP1Back = translationBackArbitraryMatrix(p1);
      if (printSteps)
      {
         System.out.println("\nStep7:");
         printMatrix(translatedP1Back);
      }

      //MULTIPLY ALL MATRICES 1 by 1
      float[][] finalMatrix = multiplyMatrices(translatedP1, ThetaAngleMatrix);

      finalMatrix = multiplyMatrices(finalMatrix, BetaAngleMatrix);

      finalMatrix = multiplyMatrices(finalMatrix, rotationMatrixX);

      finalMatrix = multiplyMatrices(finalMatrix, NegativeBetaAngleMatrix);

      finalMatrix = multiplyMatrices(finalMatrix, NegativeThetaAngleMatrix);

      finalMatrix = multiplyMatrices(finalMatrix, translatedP1Back);

      if (printSteps)
      {
         System.out.println("\n\nStep6:");
         printMatrix(finalMatrix);
      }

      return finalMatrix;
   }

   //--------------------------------- LIGHT -------------------------------------
   public Vector3 getLightVector(Vector3 pointOnPolygon, Vector3 lightPosition)
   {
      Vector3 l = getVector(lightPosition, pointOnPolygon);

      l = l.Normalize();

      return l;
   }

   public Vector3 getReflectedVector(Vector3 lightVector, float diffuseReflection, Vector3 polygonNormal)
   {
      float num = 2 * diffuseReflection;

      polygonNormal = new Vector3(polygonNormal.GetX() * num, polygonNormal.GetY() * num, polygonNormal.GetZ() * num);

      Vector3 reflectedVector = getVector(polygonNormal, lightVector);

      reflectedVector = reflectedVector.Normalize();

      return reflectedVector;
   }

   public Vector3 getViewVector(Vector3 polygonPoint, Vector3 viewPoint)
   {
      Vector3 viewVector = getVector(viewPoint, polygonPoint);

      viewVector = viewVector.Normalize();

      return viewVector;
   }
}