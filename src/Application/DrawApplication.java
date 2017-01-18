package Application;

import Framework.Vector3;
import Framework.Primitive;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import MyMathsLibrary.*;
import Framework.Light;
import Framework.Scanline;
import java.util.ArrayList;

/**
 *
 * @author DI
 */
public class DrawApplication extends javax.swing.JFrame
{
   private JFrame m_renderWindow = new JFrame("RenderWindow");
   public static MyMathLib g_MY_MATH_LIB = new MyMathLib();
   public static int g_SCREEN_WIDTH = 1000;
   public static int g_SCREEN_HEIGHT = 1000;
   private boolean m_scaleUp = false, m_scaleDown = false;
   private boolean m_playPause = true;
   private boolean m_resetCubes = false;
   private int m_selectedPolygonID = 0;
   private int m_selectedLightID = 0;
   //-------------------------COLORS--------------------------------------------
   private Color m_xyzPlaneColor, m_backgroundColor;
   //--------------------- ARBITRARY POINTS + TRANSLATION ----------------------
   private Vector3 m_arbitraryP1Point;
   private Vector3 m_arbitraryP2Point;
   private float m_arbitraryRotationDegree;
   private int m_translateX = 0, m_translateY = 0, m_translateZ = 0;
   //------------------------XYZ PLANE------------------------------------------
   //mini plane
   private Vector3 m_x1CornerXYZPlane;
   private Vector3 m_x2CornerXYZPlane;
   private Vector3 m_y1CornerXYZPlane;
   private Vector3 m_y2CornerXYZPlane;
   //big centre plane
   private Vector3 x1CenterPlane;
   private Vector3 x2CenterPlane;
   private Vector3 y1CenterPlane;
   private Vector3 y2CenterPlane;
   //---------------------------------------------------------------------------
   ArrayList<Light> m_lights = new ArrayList<Light>();
   ArrayList<Primitive> m_primitives = new ArrayList<Primitive>();

   /** Creates new form DrawApplication */
   public DrawApplication()
   {
      initComponents();

      m_renderWindow.addWindowListener(new WindowAdapter()
      {
         public void windowClosing(WindowEvent e)
         {
            System.exit(0);
         }
      });

      JApplet applet = new RenderingApplication();
      m_renderWindow.getContentPane().add("Center", applet);
      applet.init();
      m_renderWindow.pack();
      m_renderWindow.setSize(new Dimension(g_SCREEN_WIDTH, g_SCREEN_HEIGHT));
      m_renderWindow.setResizable(true);
      m_renderWindow.show();

      this.m_xyzPlaneColor = Color.GREEN;
      this.m_backgroundColor = Color.BLACK;

      m_x1CornerXYZPlane = new Vector3(10, 50, 0);
      m_x2CornerXYZPlane = new Vector3(50, 50, 0);
      m_y1CornerXYZPlane = new Vector3(30, 25, 0);
      m_y2CornerXYZPlane = new Vector3(30, 75, 0);

      this.x1CenterPlane = new Vector3(g_SCREEN_WIDTH / 2f, 0, 0);
      this.x2CenterPlane = new Vector3(g_SCREEN_WIDTH / 2f, g_SCREEN_HEIGHT, 0);
      this.y1CenterPlane = new Vector3(0, g_SCREEN_HEIGHT / 2f, 0);
      this.y2CenterPlane = new Vector3(g_SCREEN_WIDTH, g_SCREEN_HEIGHT / 2f, 0);

      applyArbitraryPoints();
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      buttonGroup1 = new javax.swing.ButtonGroup();
      RK4ResultList = new javax.swing.DefaultListModel();
      jTabbedPane1 = new javax.swing.JTabbedPane();
      TransformationsPanel = new javax.swing.JPanel();
      ArbitraryAnimationPanel = new javax.swing.JPanel();
      jLabel2 = new javax.swing.JLabel();
      P1Xspinner = new javax.swing.JSpinner();
      P1Yspinner = new javax.swing.JSpinner();
      P1Zspinner = new javax.swing.JSpinner();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      jLabel7 = new javax.swing.JLabel();
      jLabel8 = new javax.swing.JLabel();
      jLabel9 = new javax.swing.JLabel();
      P2Xspinner = new javax.swing.JSpinner();
      P2Yspinner = new javax.swing.JSpinner();
      P2Zspinner = new javax.swing.JSpinner();
      jLabel10 = new javax.swing.JLabel();
      ArbitraryDegreeSpinner = new javax.swing.JSpinner();
      ApplyArbitraryPoints = new javax.swing.JButton();
      arbitraryXaxisCheckBox = new javax.swing.JCheckBox();
      arbitraryZaxisCheckBox = new javax.swing.JCheckBox();
      arbitraryYaxisCheckBox = new javax.swing.JCheckBox();
      jLabel28 = new javax.swing.JLabel();
      playPauseButton = new javax.swing.JButton();
      Visuals = new javax.swing.JPanel();
      jPanel2 = new javax.swing.JPanel();
      scanLineCheckBox = new javax.swing.JCheckBox();
      jPanel3 = new javax.swing.JPanel();
      lightOnOffCheckBox = new javax.swing.JCheckBox();
      ambientLightSlider = new javax.swing.JSlider();
      jLabel16 = new javax.swing.JLabel();
      jLabel20 = new javax.swing.JLabel();
      distanceConstantSlider = new javax.swing.JSlider();
      jLabel21 = new javax.swing.JLabel();
      specularReflectionConstantSlider = new javax.swing.JSlider();
      jPanel10 = new javax.swing.JPanel();
      textureCheckBox = new javax.swing.JCheckBox();
      jPanel11 = new javax.swing.JPanel();
      bumpMapCheckBox = new javax.swing.JCheckBox();
      PolygonSelection = new javax.swing.JPanel();
      polygonSelectionSpinner = new javax.swing.JSpinner();
      jLabel17 = new javax.swing.JLabel();
      jPanel1 = new javax.swing.JPanel();
      translateDownButton = new javax.swing.JPanel();
      comXpositionSpinner = new javax.swing.JSpinner();
      comYpositionSpinner = new javax.swing.JSpinner();
      comZpositionSpinner = new javax.swing.JSpinner();
      jLabel11 = new javax.swing.JLabel();
      jLabel12 = new javax.swing.JLabel();
      jLabel13 = new javax.swing.JLabel();
      ApplyNewPosition = new javax.swing.JButton();
      AdditionalAnimation = new javax.swing.JCheckBox();
      jLabel14 = new javax.swing.JLabel();
      translateUpButton = new javax.swing.JButton();
      jButton6 = new javax.swing.JButton();
      translateLeftButton = new javax.swing.JButton();
      translateRightButton = new javax.swing.JButton();
      jPanel12 = new javax.swing.JPanel();
      jLabel15 = new javax.swing.JLabel();
      scaleUpButton = new javax.swing.JButton();
      scaleDownButton = new javax.swing.JButton();
      jPanel9 = new javax.swing.JPanel();
      jLabel26 = new javax.swing.JLabel();
      jLabel29 = new javax.swing.JLabel();
      selectedPolygonTextureComboBox = new javax.swing.JComboBox();
      selectedPolygonBumpMapComboBox = new javax.swing.JComboBox();
      jLabel22 = new javax.swing.JLabel();
      selectedPolygonBumpMapStrengthtSlider = new javax.swing.JSlider();
      selectedPolygonSpecularCoefficientSlider = new javax.swing.JSlider();
      jLabel19 = new javax.swing.JLabel();
      jLabel18 = new javax.swing.JLabel();
      selectedPolygonDiffuseCoefficientSlider = new javax.swing.JSlider();
      jButton1 = new javax.swing.JButton();
      selectedPolygonRemoveButton = new javax.swing.JButton();
      resetButton = new javax.swing.JButton();
      jButton3 = new javax.swing.JButton();
      LighViewPanel = new javax.swing.JPanel();
      jPanel5 = new javax.swing.JPanel();
      jLabel23 = new javax.swing.JLabel();
      viewPointXSlider = new javax.swing.JSlider();
      viewPointYSlider = new javax.swing.JSlider();
      viewPointZSlider = new javax.swing.JSlider();
      viewPointXYZCheckBox = new javax.swing.JCheckBox();
      jPanel8 = new javax.swing.JPanel();
      jLabel24 = new javax.swing.JLabel();
      selectedLightIDSpinner = new javax.swing.JSpinner();
      jLabel25 = new javax.swing.JLabel();
      selectedLightXPosition = new javax.swing.JSlider();
      selectedLightYPosition = new javax.swing.JSlider();
      selectedLightZPosition = new javax.swing.JSlider();
      removeSelectedLightButton = new javax.swing.JButton();
      addNewLightButton = new javax.swing.JButton();
      jButton4 = new javax.swing.JButton();
      showAllLightsCheckBox = new javax.swing.JCheckBox();
      SettingsPanel = new javax.swing.JPanel();
      jTabbedPane2 = new javax.swing.JTabbedPane();
      jPanel6 = new javax.swing.JPanel();
      jColorChooser1 = new javax.swing.JColorChooser();
      jLabel27 = new javax.swing.JLabel();
      interfaceColors = new javax.swing.JComboBox();
      jButton2 = new javax.swing.JButton();
      jPanel4 = new javax.swing.JPanel();
      jPanel7 = new javax.swing.JPanel();
      animationSpeed = new javax.swing.JSlider();
      ShowXYZPLaneCheckBox = new javax.swing.JCheckBox();
      jLabel1 = new javax.swing.JLabel();
      showP1P2PointsCheckBox = new javax.swing.JCheckBox();
      jMenuBar1 = new javax.swing.JMenuBar();
      FileMenuBarItem = new javax.swing.JMenu();
      exitProgramButton = new javax.swing.JMenuItem();
      ShowMenuBarItem = new javax.swing.JMenu();
      ShowRenderWindowCheckBox = new javax.swing.JCheckBoxMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("DrawAppProperties");
      setBackground(new java.awt.Color(0, 0, 0));
      setBounds(new java.awt.Rectangle(1000, 0, 0, 0));
      setName("MainFrame"); // NOI18N

      jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

      ArbitraryAnimationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Arbitrary Animation", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

      jLabel2.setText("P1:");

      P1Xspinner.setValue(500);

      P1Yspinner.setValue(500);

      jLabel3.setText("X");

      jLabel4.setText("Y");

      jLabel5.setText("Z");

      jLabel6.setText("P2:");

      jLabel7.setText("X");

      jLabel8.setText("Y");

      jLabel9.setText("Z");

      P2Xspinner.setValue(500);

      P2Yspinner.setValue(500);

      P2Zspinner.setValue(1);

      jLabel10.setText("Degree");

      ArbitraryDegreeSpinner.setValue(1);

      ApplyArbitraryPoints.setText("Apply");
      ApplyArbitraryPoints.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            ApplyArbitraryPointsActionPerformed(evt);
         }
      });

      arbitraryXaxisCheckBox.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            arbitraryXaxisCheckBoxActionPerformed(evt);
         }
      });

      arbitraryZaxisCheckBox.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            arbitraryZaxisCheckBoxActionPerformed(evt);
         }
      });

      arbitraryYaxisCheckBox.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            arbitraryYaxisCheckBoxActionPerformed(evt);
         }
      });

      jLabel28.setText("Enable/Disable P2XYZ");

      javax.swing.GroupLayout ArbitraryAnimationPanelLayout = new javax.swing.GroupLayout(ArbitraryAnimationPanel);
      ArbitraryAnimationPanel.setLayout(ArbitraryAnimationPanelLayout);
      ArbitraryAnimationPanelLayout.setHorizontalGroup(
         ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                  .addComponent(jLabel6)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel9)
                     .addComponent(jLabel8)
                     .addComponent(jLabel7))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(P2Zspinner)
                     .addComponent(P2Yspinner)
                     .addComponent(P2Xspinner, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18)
                  .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(arbitraryZaxisCheckBox)
                     .addComponent(arbitraryYaxisCheckBox)
                     .addComponent(arbitraryXaxisCheckBox)))
               .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                  .addGap(67, 67, 67)
                  .addComponent(ApplyArbitraryPoints))
               .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                  .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jLabel4)
                     .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                     .addComponent(jLabel5))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                     .addComponent(P1Zspinner, javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(P1Yspinner, javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(P1Xspinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                  .addComponent(jLabel10)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(ArbitraryDegreeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(92, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArbitraryAnimationPanelLayout.createSequentialGroup()
            .addContainerGap(126, Short.MAX_VALUE)
            .addComponent(jLabel28)
            .addContainerGap())
      );
      ArbitraryAnimationPanelLayout.setVerticalGroup(
         ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(jLabel3)
               .addComponent(P1Xspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(P1Yspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel4))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(P1Zspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel5))
            .addGap(18, 18, 18)
            .addComponent(jLabel28)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(jLabel6)
                  .addComponent(jLabel7)
                  .addComponent(P2Xspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(arbitraryXaxisCheckBox))
            .addGap(4, 4, 4)
            .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(jLabel8)
                  .addComponent(P2Yspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(arbitraryYaxisCheckBox))
            .addGap(5, 5, 5)
            .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                  .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel9)
                     .addComponent(P2Zspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                  .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel10)
                     .addComponent(ArbitraryDegreeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(33, 33, 33))
               .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                  .addComponent(arbitraryZaxisCheckBox)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
            .addComponent(ApplyArbitraryPoints)
            .addContainerGap())
      );

      playPauseButton.setText("PAUSE");
      playPauseButton.setPreferredSize(new java.awt.Dimension(120, 60));
      playPauseButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            playPauseButtonActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout TransformationsPanelLayout = new javax.swing.GroupLayout(TransformationsPanel);
      TransformationsPanel.setLayout(TransformationsPanelLayout);
      TransformationsPanelLayout.setHorizontalGroup(
         TransformationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(TransformationsPanelLayout.createSequentialGroup()
            .addGroup(TransformationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(TransformationsPanelLayout.createSequentialGroup()
                  .addGap(159, 159, 159)
                  .addComponent(ArbitraryAnimationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(TransformationsPanelLayout.createSequentialGroup()
                  .addGap(217, 217, 217)
                  .addComponent(playPauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(189, Short.MAX_VALUE))
      );
      TransformationsPanelLayout.setVerticalGroup(
         TransformationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(TransformationsPanelLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(ArbitraryAnimationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(playPauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(142, Short.MAX_VALUE))
      );

      jTabbedPane1.addTab("Arbitrary Rotation", TransformationsPanel);

      jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "SCANLINE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(204, 0, 0))); // NOI18N

      scanLineCheckBox.setText("ON/OFF");

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(scanLineCheckBox)
            .addContainerGap(14, Short.MAX_VALUE))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(scanLineCheckBox)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "GLOBAL LIGHTING", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N

      lightOnOffCheckBox.setText("ON/OFF");

      ambientLightSlider.setMaximum(1000);
      ambientLightSlider.setOrientation(javax.swing.JSlider.VERTICAL);
      ambientLightSlider.setValue(300);

      jLabel16.setText("Ambient Light Constant");

      jLabel20.setText("Distance Constant");

      distanceConstantSlider.setMaximum(1000);
      distanceConstantSlider.setOrientation(javax.swing.JSlider.VERTICAL);
      distanceConstantSlider.setValue(400);

      jLabel21.setText("Specular Reflection Constatnt");

      specularReflectionConstantSlider.setMaximum(500);
      specularReflectionConstantSlider.setOrientation(javax.swing.JSlider.VERTICAL);
      specularReflectionConstantSlider.setValue(100);

      javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
      jPanel3.setLayout(jPanel3Layout);
      jPanel3Layout.setHorizontalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel3Layout.createSequentialGroup()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel3Layout.createSequentialGroup()
                  .addGap(237, 237, 237)
                  .addComponent(lightOnOffCheckBox))
               .addGroup(jPanel3Layout.createSequentialGroup()
                  .addGap(37, 37, 37)
                  .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(ambientLightSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addComponent(distanceConstantSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                        .addComponent(specularReflectionConstantSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                     .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel20)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel21)))))
            .addContainerGap())
      );
      jPanel3Layout.setVerticalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(lightOnOffCheckBox)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel16)
               .addComponent(jLabel20)
               .addComponent(jLabel21))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(distanceConstantSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(ambientLightSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(specularReflectionConstantSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
      );

      jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "GLOBAL TEXTURING", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 0))); // NOI18N

      textureCheckBox.setText("ON/OFF");

      javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
      jPanel10.setLayout(jPanel10Layout);
      jPanel10Layout.setHorizontalGroup(
         jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel10Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(textureCheckBox)
            .addContainerGap(38, Short.MAX_VALUE))
      );
      jPanel10Layout.setVerticalGroup(
         jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel10Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(textureCheckBox)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "GLOBAL BUMP MAPING", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 0))); // NOI18N

      bumpMapCheckBox.setText("ON/OFF");

      javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
      jPanel11.setLayout(jPanel11Layout);
      jPanel11Layout.setHorizontalGroup(
         jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel11Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(bumpMapCheckBox)
            .addContainerGap(50, Short.MAX_VALUE))
      );
      jPanel11Layout.setVerticalGroup(
         jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel11Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(bumpMapCheckBox)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout VisualsLayout = new javax.swing.GroupLayout(Visuals);
      Visuals.setLayout(VisualsLayout);
      VisualsLayout.setHorizontalGroup(
         VisualsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(VisualsLayout.createSequentialGroup()
            .addGroup(VisualsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, VisualsLayout.createSequentialGroup()
                  .addGap(22, 22, 22)
                  .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, VisualsLayout.createSequentialGroup()
                  .addGap(118, 118, 118)
                  .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(5, 5, 5)
                  .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(1, 1, 1)
                  .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(52, Short.MAX_VALUE))
      );
      VisualsLayout.setVerticalGroup(
         VisualsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VisualsLayout.createSequentialGroup()
            .addGroup(VisualsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(VisualsLayout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(VisualsLayout.createSequentialGroup()
                  .addGap(67, 67, 67)
                  .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(VisualsLayout.createSequentialGroup()
                  .addGap(67, 67, 67)
                  .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(1361, 1361, 1361))
      );

      jTabbedPane1.addTab("Visual Editor", Visuals);

      polygonSelectionSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            polygonSelectionSpinnerStateChanged(evt);
         }
      });

      jLabel17.setText("Selected Polygon ID:");

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Polygons Properties", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

      translateDownButton.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Translation/Scaling", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N

      comXpositionSpinner.setValue(50);

      comYpositionSpinner.setValue(50);

      jLabel11.setText("Y");

      jLabel12.setText("Z");

      jLabel13.setText("X");

      ApplyNewPosition.setText("Apply");
      ApplyNewPosition.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            ApplyNewPositionActionPerformed(evt);
         }
      });

      AdditionalAnimation.setText("Animate Translation");

      jLabel14.setText("Translation");

      translateUpButton.setText("U");
      translateUpButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            translateUpButtonActionPerformed(evt);
         }
      });

      jButton6.setText("D");
      jButton6.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton6ActionPerformed(evt);
         }
      });

      translateLeftButton.setText("L");
      translateLeftButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            translateLeftButtonActionPerformed(evt);
         }
      });

      translateRightButton.setText("R");
      translateRightButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            translateRightButtonActionPerformed(evt);
         }
      });

      jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

      jLabel15.setText("Scaling");

      scaleUpButton.setText("ScaleUp");
      scaleUpButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            scaleUpButtonActionPerformed(evt);
         }
      });

      scaleDownButton.setText("ScaleDown");
      scaleDownButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            scaleDownButtonActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
      jPanel12.setLayout(jPanel12Layout);
      jPanel12Layout.setHorizontalGroup(
         jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
            .addContainerGap(11, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(scaleUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(scaleDownButton)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                  .addComponent(jLabel15)
                  .addGap(25, 25, 25)))
            .addContainerGap())
      );
      jPanel12Layout.setVerticalGroup(
         jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel15)
            .addGap(9, 9, 9)
            .addComponent(scaleUpButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(scaleDownButton)
            .addContainerGap())
      );

      javax.swing.GroupLayout translateDownButtonLayout = new javax.swing.GroupLayout(translateDownButton);
      translateDownButton.setLayout(translateDownButtonLayout);
      translateDownButtonLayout.setHorizontalGroup(
         translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(translateDownButtonLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(translateDownButtonLayout.createSequentialGroup()
                  .addGroup(translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(translateDownButtonLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel14))
                     .addGroup(translateDownButtonLayout.createSequentialGroup()
                        .addGroup(translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                           .addComponent(jLabel12)
                           .addComponent(jLabel11)
                           .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(comZpositionSpinner)
                           .addComponent(comYpositionSpinner)
                           .addComponent(comXpositionSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(AdditionalAnimation)
                           .addGroup(translateDownButtonLayout.createSequentialGroup()
                              .addGap(21, 21, 21)
                              .addComponent(ApplyNewPosition)))))
                  .addGap(51, 51, 51))
               .addGroup(translateDownButtonLayout.createSequentialGroup()
                  .addComponent(translateLeftButton)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                     .addComponent(translateUpButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(translateRightButton)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                  .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addContainerGap())))
      );
      translateDownButtonLayout.setVerticalGroup(
         translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(translateDownButtonLayout.createSequentialGroup()
            .addGroup(translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(translateDownButtonLayout.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(comXpositionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel13))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel11)
                     .addComponent(comYpositionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(comZpositionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel12)))
               .addGroup(translateDownButtonLayout.createSequentialGroup()
                  .addComponent(jLabel14)
                  .addGap(18, 18, 18)
                  .addComponent(AdditionalAnimation)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(ApplyNewPosition)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
            .addGroup(translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(translateDownButtonLayout.createSequentialGroup()
                  .addGroup(translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addGroup(translateDownButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(translateDownButtonLayout.createSequentialGroup()
                           .addComponent(translateUpButton)
                           .addGap(18, 18, 18)
                           .addComponent(jButton6))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, translateDownButtonLayout.createSequentialGroup()
                           .addComponent(translateRightButton)
                           .addGap(22, 22, 22)))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, translateDownButtonLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(translateLeftButton)
                        .addGap(24, 24, 24)))
                  .addGap(18, 18, 18))
               .addGroup(translateDownButtonLayout.createSequentialGroup()
                  .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addContainerGap())))
      );

      jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Properties", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 0))); // NOI18N

      jLabel26.setText("Texture:");

      jLabel29.setText("Bump Map:");

      selectedPolygonTextureComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Texture1", "Texture2", "Texture3" }));
      selectedPolygonTextureComboBox.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            selectedPolygonTextureComboBoxActionPerformed(evt);
         }
      });

      selectedPolygonBumpMapComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bump Map 1", "Bump Map 2", "Bump Map 3" }));
      selectedPolygonBumpMapComboBox.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            selectedPolygonBumpMapComboBoxActionPerformed(evt);
         }
      });

      jLabel22.setText("Bump Map Strength");

      selectedPolygonBumpMapStrengthtSlider.setMaximum(90);
      selectedPolygonBumpMapStrengthtSlider.setMinimum(1);
      selectedPolygonBumpMapStrengthtSlider.setPaintTicks(true);
      selectedPolygonBumpMapStrengthtSlider.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            selectedPolygonBumpMapStrengthtSliderStateChanged(evt);
         }
      });

      selectedPolygonSpecularCoefficientSlider.setPaintLabels(true);
      selectedPolygonSpecularCoefficientSlider.setPaintTicks(true);
      selectedPolygonSpecularCoefficientSlider.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            selectedPolygonSpecularCoefficientSliderStateChanged(evt);
         }
      });

      jLabel19.setText("Specular Coefficient");

      jLabel18.setText("Diffuse Coefficient");

      selectedPolygonDiffuseCoefficientSlider.setPaintTicks(true);
      selectedPolygonDiffuseCoefficientSlider.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            selectedPolygonDiffuseCoefficientSliderStateChanged(evt);
         }
      });

      jButton1.setText("Add New Polygon");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      selectedPolygonRemoveButton.setText("Remove Selected Polygon");
      selectedPolygonRemoveButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            selectedPolygonRemoveButtonActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
      jPanel9.setLayout(jPanel9Layout);
      jPanel9Layout.setHorizontalGroup(
         jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(selectedPolygonRemoveButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                  .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel29)
                     .addComponent(jLabel26))
                  .addGap(18, 18, 18)
                  .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                     .addComponent(selectedPolygonTextureComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(selectedPolygonBumpMapComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                  .addGap(17, 17, 17)
                  .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(selectedPolygonSpecularCoefficientSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectedPolygonDiffuseCoefficientSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel22))
                     .addComponent(selectedPolygonBumpMapStrengthtSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel19))
                     .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel18))))
               .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
            .addContainerGap())
      );
      jPanel9Layout.setVerticalGroup(
         jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel9Layout.createSequentialGroup()
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel9Layout.createSequentialGroup()
                  .addComponent(jLabel26)
                  .addGap(24, 24, 24)
                  .addComponent(jLabel29))
               .addGroup(jPanel9Layout.createSequentialGroup()
                  .addComponent(selectedPolygonTextureComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(24, 24, 24)
                  .addComponent(selectedPolygonBumpMapComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(jLabel18)
            .addComponent(selectedPolygonDiffuseCoefficientSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jLabel19)
            .addComponent(selectedPolygonSpecularCoefficientSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jLabel22)
            .addComponent(selectedPolygonBumpMapStrengthtSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
            .addComponent(selectedPolygonRemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );

      resetButton.setText("Reset Positions");
      resetButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            resetButtonActionPerformed(evt);
         }
      });

      jButton3.setText("Deselect");
      jButton3.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(translateDownButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(81, 81, 81))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(translateDownButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29)
            .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(28, 28, 28))
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
      );

      javax.swing.GroupLayout PolygonSelectionLayout = new javax.swing.GroupLayout(PolygonSelection);
      PolygonSelection.setLayout(PolygonSelectionLayout);
      PolygonSelectionLayout.setHorizontalGroup(
         PolygonSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(PolygonSelectionLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(PolygonSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGroup(PolygonSelectionLayout.createSequentialGroup()
                  .addComponent(jLabel17)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(polygonSelectionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
      );
      PolygonSelectionLayout.setVerticalGroup(
         PolygonSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(PolygonSelectionLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(PolygonSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel17)
               .addComponent(polygonSelectionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
      );

      jTabbedPane1.addTab("Polygon Editor", PolygonSelection);

      jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "View", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N

      jLabel23.setText("View XYZ Position");

      viewPointXSlider.setMaximum(1000);
      viewPointXSlider.setOrientation(javax.swing.JSlider.VERTICAL);
      viewPointXSlider.setValue(700);

      viewPointYSlider.setMaximum(1000);
      viewPointYSlider.setOrientation(javax.swing.JSlider.VERTICAL);
      viewPointYSlider.setValue(150);

      viewPointZSlider.setMaximum(1000);
      viewPointZSlider.setOrientation(javax.swing.JSlider.VERTICAL);
      viewPointZSlider.setValue(400);

      viewPointXYZCheckBox.setSelected(true);
      viewPointXYZCheckBox.setText("Show Location");

      javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
      jPanel5.setLayout(jPanel5Layout);
      jPanel5Layout.setHorizontalGroup(
         jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel5Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel23)
               .addGroup(jPanel5Layout.createSequentialGroup()
                  .addGap(10, 10, 10)
                  .addComponent(viewPointXSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)
                  .addComponent(viewPointYSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)
                  .addComponent(viewPointZSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(viewPointXYZCheckBox))
            .addContainerGap(33, Short.MAX_VALUE))
      );
      jPanel5Layout.setVerticalGroup(
         jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel5Layout.createSequentialGroup()
            .addComponent(jLabel23)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(viewPointXSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(viewPointYSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(viewPointZSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(viewPointXYZCheckBox)
            .addContainerGap(16, Short.MAX_VALUE))
      );

      jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Light", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N

      jLabel24.setText("Selected Light ID: ");

      selectedLightIDSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            selectedLightIDSpinnerStateChanged(evt);
         }
      });

      jLabel25.setText("Position XYZ");

      selectedLightXPosition.setMaximum(1000);
      selectedLightXPosition.setOrientation(javax.swing.JSlider.VERTICAL);
      selectedLightXPosition.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            selectedLightXPositionStateChanged(evt);
         }
      });

      selectedLightYPosition.setMaximum(1000);
      selectedLightYPosition.setOrientation(javax.swing.JSlider.VERTICAL);
      selectedLightYPosition.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            selectedLightYPositionStateChanged(evt);
         }
      });

      selectedLightZPosition.setMaximum(1000);
      selectedLightZPosition.setOrientation(javax.swing.JSlider.VERTICAL);
      selectedLightZPosition.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            selectedLightZPositionStateChanged(evt);
         }
      });

      removeSelectedLightButton.setText("REMOVE SELECTED LIGHT");
      removeSelectedLightButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            removeSelectedLightButtonActionPerformed(evt);
         }
      });

      addNewLightButton.setText("ADD NEW LIGHT");
      addNewLightButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            addNewLightButtonActionPerformed(evt);
         }
      });

      jButton4.setText("DESELECT");
      jButton4.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
         }
      });

      showAllLightsCheckBox.setText("Show All Lights");

      javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
      jPanel8.setLayout(jPanel8Layout);
      jPanel8Layout.setHorizontalGroup(
         jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel8Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel8Layout.createSequentialGroup()
                  .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(selectedLightXPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(selectedLightYPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(selectedLightZPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addComponent(jLabel25))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                  .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(32, 32, 32))
               .addGroup(jPanel8Layout.createSequentialGroup()
                  .addComponent(jLabel24)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(selectedLightIDSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(26, 26, 26)
                  .addComponent(showAllLightsCheckBox)
                  .addContainerGap(65, Short.MAX_VALUE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                  .addComponent(addNewLightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addContainerGap())
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                  .addComponent(removeSelectedLightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addContainerGap())))
      );
      jPanel8Layout.setVerticalGroup(
         jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel8Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel24)
               .addComponent(selectedLightIDSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(showAllLightsCheckBox))
            .addGap(18, 18, 18)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(jPanel8Layout.createSequentialGroup()
                  .addComponent(jLabel25)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(selectedLightXPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectedLightYPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectedLightZPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(addNewLightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeSelectedLightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout LighViewPanelLayout = new javax.swing.GroupLayout(LighViewPanel);
      LighViewPanel.setLayout(LighViewPanelLayout);
      LighViewPanelLayout.setHorizontalGroup(
         LighViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LighViewPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );
      LighViewPanelLayout.setVerticalGroup(
         LighViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(LighViewPanelLayout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addGroup(LighViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(239, Short.MAX_VALUE))
      );

      jTabbedPane1.addTab("Light/View Editor", LighViewPanel);

      jColorChooser1.setColor(new java.awt.Color(0, 153, 204));

      jLabel27.setText("Components Color:");

      interfaceColors.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "XYZ Plane", "Background" }));

      jButton2.setText("Apply Color");
      jButton2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
      jPanel6.setLayout(jPanel6Layout);
      jPanel6Layout.setHorizontalGroup(
         jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel6Layout.createSequentialGroup()
            .addGap(74, 74, 74)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(jPanel6Layout.createSequentialGroup()
                  .addGap(108, 108, 108)
                  .addComponent(jLabel27)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(interfaceColors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel6Layout.createSequentialGroup()
                  .addGap(155, 155, 155)
                  .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(81, Short.MAX_VALUE))
      );
      jPanel6Layout.setVerticalGroup(
         jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel6Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(interfaceColors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel27))
            .addGap(18, 18, 18)
            .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(164, Short.MAX_VALUE))
      );

      jTabbedPane2.addTab("Color", jPanel6);

      jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

      jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

      animationSpeed.setMaximum(250);
      animationSpeed.setValue(0);
      animationSpeed.setInverted(true);

      ShowXYZPLaneCheckBox.setSelected(true);
      ShowXYZPLaneCheckBox.setText("Show XYZ Plane");

      jLabel1.setText("-                  Animation Speed                +");

      showP1P2PointsCheckBox.setSelected(true);
      showP1P2PointsCheckBox.setText("Show P1,P2 Points");

      javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
      jPanel7.setLayout(jPanel7Layout);
      jPanel7Layout.setHorizontalGroup(
         jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
            .addContainerGap(41, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(showP1P2PointsCheckBox)
               .addComponent(ShowXYZPLaneCheckBox))
            .addGap(68, 68, 68))
         .addGroup(jPanel7Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
               .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(animationSpeed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(14, Short.MAX_VALUE))
      );
      jPanel7Layout.setVerticalGroup(
         jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel7Layout.createSequentialGroup()
            .addGap(9, 9, 9)
            .addComponent(ShowXYZPLaneCheckBox)
            .addGap(18, 18, 18)
            .addComponent(showP1P2PointsCheckBox)
            .addGap(18, 18, 18)
            .addComponent(jLabel1)
            .addComponent(animationSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(46, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
      jPanel4.setLayout(jPanel4Layout);
      jPanel4Layout.setHorizontalGroup(
         jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel4Layout.createSequentialGroup()
            .addGap(153, 153, 153)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(197, Short.MAX_VALUE))
      );
      jPanel4Layout.setVerticalGroup(
         jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(335, Short.MAX_VALUE))
      );

      jTabbedPane2.addTab("More", jPanel4);

      javax.swing.GroupLayout SettingsPanelLayout = new javax.swing.GroupLayout(SettingsPanel);
      SettingsPanel.setLayout(SettingsPanelLayout);
      SettingsPanelLayout.setHorizontalGroup(
         SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(SettingsPanelLayout.createSequentialGroup()
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
            .addContainerGap())
      );
      SettingsPanelLayout.setVerticalGroup(
         SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(SettingsPanelLayout.createSequentialGroup()
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
            .addContainerGap())
      );

      jTabbedPane1.addTab("Settings", SettingsPanel);

      FileMenuBarItem.setText("File");

      exitProgramButton.setText("Exit");
      exitProgramButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            exitProgramButtonActionPerformed(evt);
         }
      });
      FileMenuBarItem.add(exitProgramButton);

      jMenuBar1.add(FileMenuBarItem);

      ShowMenuBarItem.setText("Show");

      ShowRenderWindowCheckBox.setSelected(true);
      ShowRenderWindowCheckBox.setText("RenderWindow");
      ShowRenderWindowCheckBox.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            ShowRenderWindowCheckBoxActionPerformed(evt);
         }
      });
      ShowMenuBarItem.add(ShowRenderWindowCheckBox);

      jMenuBar1.add(ShowMenuBarItem);

      setJMenuBar(jMenuBar1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(18, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

//Java Automatically Generated Code
private void exitProgramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitProgramButtonActionPerformed
// TODO add your handling code here:
   System.exit(0);
}//GEN-LAST:event_exitProgramButtonActionPerformed

//Java Automatically Generated Code
private void ShowRenderWindowCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowRenderWindowCheckBoxActionPerformed
// TODO add your handling code here:
   if (ShowRenderWindowCheckBox.isSelected())
   {
      m_renderWindow.show();
   }
   else
   {
      m_renderWindow.hide();
   }
}//GEN-LAST:event_ShowRenderWindowCheckBoxActionPerformed

//Java Automatically Generated Code   
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
   int option = interfaceColors.getSelectedIndex();

   if (option == 0)
   {
      this.m_xyzPlaneColor = jColorChooser1.getColor();
   }
   else if (option == 1)
   {
      this.m_backgroundColor = jColorChooser1.getColor();
   }
}//GEN-LAST:event_jButton2ActionPerformed

//Java Automatically Generated Code 
private void playPauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPauseButtonActionPerformed
// TODO add your handling code here:
   if (m_playPause)
   {
      m_playPause = false;
      playPauseButton.setText("Play");
   }
   else if (!m_playPause)
   {
      m_playPause = true;
      playPauseButton.setText("Pause");
   }
}//GEN-LAST:event_playPauseButtonActionPerformed

//Java Automatically Generated Code 
private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
// TODO add your handling code here:
   m_resetCubes = true;
}//GEN-LAST:event_resetButtonActionPerformed

//Java Automatically Generated Code 
private void scaleDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleDownButtonActionPerformed
// TODO add your handling code here:
   m_scaleDown = true;
}//GEN-LAST:event_scaleDownButtonActionPerformed

private void scaleUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleUpButtonActionPerformed
// TODO add your handling code here:
   m_scaleUp = true;
}//GEN-LAST:event_scaleUpButtonActionPerformed

//Java Automatically Generated Code 
private void ApplyNewPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyNewPositionActionPerformed
// TODO add your handling code here:
   m_translateX = Integer.parseInt(comXpositionSpinner.getValue().toString());
   m_translateY = Integer.parseInt(comYpositionSpinner.getValue().toString());
   m_translateZ = Integer.parseInt(comZpositionSpinner.getValue().toString());
}//GEN-LAST:event_ApplyNewPositionActionPerformed

//Java Automatically Generated Code 
private void arbitraryYaxisCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arbitraryYaxisCheckBoxActionPerformed
// TODO add your handling code here:
   applyArbitraryPoints();
}//GEN-LAST:event_arbitraryYaxisCheckBoxActionPerformed

//Java Automatically Generated Code 
private void arbitraryZaxisCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arbitraryZaxisCheckBoxActionPerformed
// TODO add your handling code here:
   applyArbitraryPoints();
}//GEN-LAST:event_arbitraryZaxisCheckBoxActionPerformed

private void arbitraryXaxisCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arbitraryXaxisCheckBoxActionPerformed
// TODO add your handling code here:
   applyArbitraryPoints();
}//GEN-LAST:event_arbitraryXaxisCheckBoxActionPerformed

//Java Automatically Generated Code 
private void ApplyArbitraryPointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyArbitraryPointsActionPerformed
// TODO add your handling code here:
   applyArbitraryPoints();
}//GEN-LAST:event_ApplyArbitraryPointsActionPerformed

//Java Automatically Generated Code 
private void polygonSelectionSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_polygonSelectionSpinnerStateChanged
// TODO add your handling code here:
   if (m_primitives.size() > 0)
   {
      m_selectedPolygonID = Integer.parseInt(polygonSelectionSpinner.getValue().toString());

      if (m_selectedPolygonID >= m_primitives.size() - 1)
      {
         polygonSelectionSpinner.setValue(m_primitives.size() - 1);

         m_selectedPolygonID = m_primitives.size() - 1;
      }
      else if (m_selectedPolygonID <= 0)
      {
         polygonSelectionSpinner.setValue(0);

         m_selectedPolygonID = 0;
      }

      for (Primitive polygon : m_primitives)
      {
         polygon.setSelectedState(false);
      }

      if (m_selectedPolygonID >= 0 && m_selectedPolygonID <= m_primitives.size() - 1)
      {
         m_primitives.get(m_selectedPolygonID).setSelectedState(true);
      }

      selectedPolygonDiffuseCoefficientSlider.setValue((int) (m_primitives.get(m_selectedPolygonID).getKd() * 100));
      selectedPolygonSpecularCoefficientSlider.setValue((int) (m_primitives.get(m_selectedPolygonID).getKs() * 100));
      selectedPolygonBumpMapStrengthtSlider.setValue((int) (m_primitives.get(m_selectedPolygonID).getBumpMapStrength() * 100));
   }
   else
   {
      polygonSelectionSpinner.setValue(0);
      m_selectedPolygonID = 0;
   }

}//GEN-LAST:event_polygonSelectionSpinnerStateChanged

//Java Automatically Generated Code 
private void selectedPolygonDiffuseCoefficientSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_selectedPolygonDiffuseCoefficientSliderStateChanged
// TODO add your handling code here:
   int difference = 0;
   int diffuseValue = 0;

   diffuseValue = selectedPolygonDiffuseCoefficientSlider.getValue();

   difference = 100 - diffuseValue;

   selectedPolygonSpecularCoefficientSlider.setValue(difference);

   if (m_primitives.size() > 0)
   {
      m_primitives.get(m_selectedPolygonID).setKs(difference / 100f);
   }
}//GEN-LAST:event_selectedPolygonDiffuseCoefficientSliderStateChanged

//Java Automatically Generated Code 
private void selectedPolygonSpecularCoefficientSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_selectedPolygonSpecularCoefficientSliderStateChanged
// TODO add your handling code here:
   int difference = 0;
   int specularValue = 0;

   specularValue = selectedPolygonSpecularCoefficientSlider.getValue();

   difference = 100 - specularValue;

   selectedPolygonDiffuseCoefficientSlider.setValue(difference);

   if (m_primitives.size() > 0)
   {
      m_primitives.get(m_selectedPolygonID).setKd(difference / 100f);
   }
}//GEN-LAST:event_selectedPolygonSpecularCoefficientSliderStateChanged

//Java Automatically Generated Code 
private void selectedPolygonRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedPolygonRemoveButtonActionPerformed
// TODO add your handling code here:
   if (m_primitives.size() > 0 && m_selectedPolygonID > -1)
   {
      m_primitives.remove(m_selectedPolygonID);

      if (m_selectedPolygonID > m_primitives.size() - 1)
      {
         polygonSelectionSpinner.setValue(m_primitives.size() - 1);
         m_selectedPolygonID = m_primitives.size() - 1;
      }
   }
}//GEN-LAST:event_selectedPolygonRemoveButtonActionPerformed

//Java Automatically Generated Code 
private void selectedPolygonBumpMapStrengthtSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_selectedPolygonBumpMapStrengthtSliderStateChanged
// TODO add your handling code here:
   if (m_primitives.size() > 0)
   {
      m_primitives.get(m_selectedPolygonID).setBumpMapStrength((float) (selectedPolygonBumpMapStrengthtSlider.getValue() / 100f));
   }
}//GEN-LAST:event_selectedPolygonBumpMapStrengthtSliderStateChanged

//Java Automatically Generated Code 
private void selectedLightIDSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_selectedLightIDSpinnerStateChanged
// TODO add your handling code here:
   if (m_lights.size() > 0)
   {
      m_selectedLightID = Integer.parseInt(selectedLightIDSpinner.getValue().toString());

      if (m_selectedLightID >= m_lights.size() - 1)
      {
         selectedLightIDSpinner.setValue(m_lights.size() - 1);

         m_selectedLightID = m_lights.size() - 1;
      }
      else if (m_selectedLightID <= 0)
      {
         selectedLightIDSpinner.setValue(0);

         m_selectedLightID = 0;
      }

      for (Light light : m_lights)
      {
         light.setIsSelected(false);
      }

      if (m_selectedLightID >= 0 && m_selectedLightID <= m_lights.size() - 1)
      {
         m_lights.get(m_selectedLightID).setIsSelected(true);
      }

      selectedLightXPosition.setValue((int) m_lights.get(m_selectedLightID).getPostion().GetX());
      selectedLightYPosition.setValue((int) m_lights.get(m_selectedLightID).getPostion().GetY());
      selectedLightZPosition.setValue(-(int) m_lights.get(m_selectedLightID).getPostion().GetZ());
   }
   else
   {
      selectedLightIDSpinner.setValue(0);
      m_selectedLightID = 0;
   }
}//GEN-LAST:event_selectedLightIDSpinnerStateChanged

//Java Automatically Generated Code 
private void selectedLightXPositionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_selectedLightXPositionStateChanged
// TODO add your handling code here:   
   if (m_lights.size() > 0)
   {
      m_lights.get(m_selectedLightID).setXPosition(selectedLightXPosition.getValue());
   }
}//GEN-LAST:event_selectedLightXPositionStateChanged

//Java Automatically Generated Code 
private void selectedLightYPositionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_selectedLightYPositionStateChanged
// TODO add your handling code here:   
   if (m_lights.size() > 0)
   {
      m_lights.get(m_selectedLightID).setYPosition(selectedLightYPosition.getValue());
   }
}//GEN-LAST:event_selectedLightYPositionStateChanged

//Java Automatically Generated Code 
private void selectedLightZPositionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_selectedLightZPositionStateChanged
// TODO add your handling code here:   
   if (m_lights.size() > 0)
   {
      m_lights.get(m_selectedLightID).setZPosition(-selectedLightZPosition.getValue());
   }
}//GEN-LAST:event_selectedLightZPositionStateChanged

//Java Automatically Generated Code
private void removeSelectedLightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSelectedLightButtonActionPerformed
// TODO add your handling code here:
   if (m_lights.size() > 0 && m_selectedLightID > -1)
   {
      m_lights.remove(m_selectedLightID);

      if (m_selectedLightID > m_lights.size() - 1)
      {
         selectedLightIDSpinner.setValue(m_lights.size() - 1);
         m_selectedLightID = m_lights.size() - 1;
      }
   }
}//GEN-LAST:event_removeSelectedLightButtonActionPerformed

//Java Automatically Generated Code
private void addNewLightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewLightButtonActionPerformed
// TODO add your handling code here:
   m_lights.add(new Light(new Vector3((float) g_SCREEN_WIDTH / 2f, (float) g_SCREEN_HEIGHT / 2f, 0), Color.white));

   for (Light light : m_lights)
   {
      light.setIsSelected(false);
   }

   m_selectedLightID = m_lights.size() - 1;
   m_lights.get(m_selectedLightID).setIsSelected(true);
   selectedLightIDSpinner.setValue(m_lights.size() - 1);
}//GEN-LAST:event_addNewLightButtonActionPerformed

//Java Automatically Generated Code
private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
   for (Light light : m_lights)
   {
      light.setIsSelected(false);
   }
}//GEN-LAST:event_jButton4ActionPerformed

//Java Automatically Generated Code
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:

   float xMiddle = g_SCREEN_WIDTH / 2f;
   float yMiddle = g_SCREEN_HEIGHT / 2f;

   Vector3[] vertices =
   {
      new Vector3(xMiddle - 50, yMiddle - 50, 0), new Vector3(xMiddle + 50, yMiddle - 50, 0),
      new Vector3(xMiddle + 50, yMiddle + 50, 0), new Vector3(xMiddle - 50, yMiddle + 50, 0)
   };

   m_primitives.add(new Primitive(vertices, 0.5f, 0.5f, "texture1.jpg", "bumpMap1.jpg"));

   for (Primitive polygon : m_primitives)
   {
      polygon.setSelectedState(false);
   }

   m_selectedPolygonID = m_primitives.size() - 1;
   m_primitives.get(m_selectedPolygonID).setSelectedState(true);
   polygonSelectionSpinner.setValue(m_primitives.size() - 1);

}//GEN-LAST:event_jButton1ActionPerformed

//Java Automatically Generated Code
private void selectedPolygonTextureComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedPolygonTextureComboBoxActionPerformed
// TODO add your handling code here:

   if (selectedPolygonTextureComboBox.getSelectedIndex() == 0)
   {
      m_primitives.get(m_selectedPolygonID).setNewTexture("texture1.jpg");
   }
   else if (selectedPolygonTextureComboBox.getSelectedIndex() == 1)
   {
      m_primitives.get(m_selectedPolygonID).setNewTexture("texture2.jpg");
   }
   else if (selectedPolygonTextureComboBox.getSelectedIndex() == 2)
   {
      m_primitives.get(m_selectedPolygonID).setNewTexture("texture3.jpg");
   }
}//GEN-LAST:event_selectedPolygonTextureComboBoxActionPerformed

//Java Automatically Generated Code
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
   for (Primitive polygon : m_primitives)
   {
      polygon.setSelectedState(false);
   }
}//GEN-LAST:event_jButton3ActionPerformed

//Java Automatically Generated Code
private void translateUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translateUpButtonActionPerformed
// TODO add your handling code here:
   m_translateY = -Integer.parseInt(comYpositionSpinner.getValue().toString());
}//GEN-LAST:event_translateUpButtonActionPerformed

//Java Automatically Generated Code
private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
   m_translateY = Integer.parseInt(comYpositionSpinner.getValue().toString());
}//GEN-LAST:event_jButton6ActionPerformed

//Java Automatically Generated Code
private void translateLeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translateLeftButtonActionPerformed
// TODO add your handling code here:
   m_translateX = -Integer.parseInt(comXpositionSpinner.getValue().toString());
}//GEN-LAST:event_translateLeftButtonActionPerformed

private void translateRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translateRightButtonActionPerformed
// TODO add your handling code here:
   m_translateX = Integer.parseInt(comXpositionSpinner.getValue().toString());
}//GEN-LAST:event_translateRightButtonActionPerformed

//Java Automatically Generated Code
private void selectedPolygonBumpMapComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedPolygonBumpMapComboBoxActionPerformed
// TODO add your handling code here:
   if (selectedPolygonBumpMapComboBox.getSelectedIndex() == 0)
   {
      m_primitives.get(m_selectedPolygonID).setNewBumpMap("bumpMap1.jpg");
   }
   else if (selectedPolygonBumpMapComboBox.getSelectedIndex() == 1)
   {
      m_primitives.get(m_selectedPolygonID).setNewBumpMap("bumpMap2.jpg");
   }
   else if (selectedPolygonBumpMapComboBox.getSelectedIndex() == 2)
   {
      m_primitives.get(m_selectedPolygonID).setNewBumpMap("bumpMap3.jpg");
   }
}//GEN-LAST:event_selectedPolygonBumpMapComboBoxActionPerformed

//Java Automatically Generated Code
   public static void main(String args[])
   {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
       * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try
      {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
         {
            if ("Nimbus".equals(info.getName()))
            {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex)
      {
         java.util.logging.Logger.getLogger(RenderingApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex)
      {
         java.util.logging.Logger.getLogger(RenderingApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex)
      {
         java.util.logging.Logger.getLogger(RenderingApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex)
      {
         java.util.logging.Logger.getLogger(RenderingApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
        /* Create and display the form */

      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new DrawApplication().setVisible(true);
         }
      });
   }
//--------------------------------------------------------------------------------

   public class RenderingApplication extends JApplet
   {
      public void init()
      {
         getContentPane().add(new AnimationPanel());
      }

      public class AnimationPanel extends JPanel
      {
         Vector3[] m_polygonVertices1 =
         {
            new Vector3(100, 100, 0), new Vector3(200, 100, 0),
            new Vector3(200, 200, 0), new Vector3(100, 200, 0),
         };
         Primitive m_polygon1 = new Primitive(m_polygonVertices1, 0.7f, 0.3f, "texture1.jpg", "bumpMap1.jpg");
         Scanline m_scanline;
         Light m_light1 = new Light(new Vector3(50, 50, -300), Color.WHITE);

         public AnimationPanel()
         {
            m_scanline = new Scanline();

            //m_lights.add(m_light1);

            //m_primitives.add(m_polygon1);
         }

         public void paintComponent(Graphics g)
         {
            try
            {
               super.paintComponent(g);
               setBackground(m_backgroundColor);

               //g.translate(m_renderWindow.getSize().width / 2, m_renderWindow.getSize().height / 2);

               if (m_resetCubes)
               {
                  for (Primitive polygon : m_primitives)
                  {
                     polygon.reset();
                  }
                  m_resetCubes = false;
               }

               if (scanLineCheckBox.isSelected())
               {
                  int x = viewPointXSlider.getValue();
                  int y = viewPointYSlider.getValue();
                  int z = -viewPointZSlider.getValue();

                  m_scanline.performScan(g, this, new Vector3(x, y, z), m_primitives, m_lights, (float) (ambientLightSlider.getValue() / 1000f), (float) (distanceConstantSlider.getValue() / 1000f), specularReflectionConstantSlider.getValue(), textureCheckBox.isSelected(), bumpMapCheckBox.isSelected(), lightOnOffCheckBox.isSelected());               
               }

               if (viewPointXYZCheckBox.isSelected())
               {
                  int x = viewPointXSlider.getValue();
                  int y = viewPointYSlider.getValue();
                  g.setColor(Color.RED);

                  if (x <= 0)
                  {
                     x = 5;
                  }
                  else if (x >= 980)
                  {
                     x = 900;
                  }

                  if (y <= 0)
                  {
                     y = 10;
                  }
                  else if (y >= 980)
                  {
                     y = 960;
                  }
                  g.drawString("VIEW POINT", x, y);
               }               
               
               if(showAllLightsCheckBox.isSelected())
               {
                  drawLightPosition(g);
               }
               else
               {
                  for(Light light:m_lights)
                  {
                     if(light.checkIfSelected())
                     {
                        light.drawSelectedPosition(g);
                     }
                  }
               }

               drawCube(g);

               if (m_translateX != 0 || m_translateY != 0 || m_translateZ != 0)
               {
                  Translate();
               }
               else
               {
                  if (m_playPause)
                  {
                     if (arbitraryXaxisCheckBox.isSelected() || arbitraryYaxisCheckBox.isSelected() || arbitraryZaxisCheckBox.isSelected())
                     {
                        rotateAroundArbitraryAxis();
                     }
                  }
               }

               if (ShowXYZPLaneCheckBox.isSelected())
               {
                  drawXYZPlane(g);
               }

               if (showP1P2PointsCheckBox.isSelected())
               {
                  drawP1P2Points(g);
               }

               if (m_scaleUp || m_scaleDown)
               {
                  scale();
               }

               repaint();

               Thread.sleep(animationSpeed.getValue());
            } catch (InterruptedException ex)
            {
               //do nothing
            }
         }

         //draws all the lines of hte cube on hte screen
         private void drawCube(Graphics g)
         {
            for (Primitive polygon : m_primitives)
            {
               polygon.draw(g, scanLineCheckBox.isSelected());
            }
         }

         private void drawLightPosition(Graphics g)
         {
            for (Light ligh : m_lights)
            {
               ligh.drawPosition(g);
            }
         }

         private void drawXYZPlane(Graphics g)
         {
            g.setColor(m_xyzPlaneColor);

            g.drawString("X", (int) m_x2CornerXYZPlane.GetX() + 5, (int) m_x2CornerXYZPlane.GetY() + 5);
            g.drawLine((int) m_x1CornerXYZPlane.GetX(), (int) m_x1CornerXYZPlane.GetY(), (int) m_x2CornerXYZPlane.GetX(), (int) m_x2CornerXYZPlane.GetY());
            g.drawString("Y", (int) m_y1CornerXYZPlane.GetX() - 3, (int) m_y1CornerXYZPlane.GetY() - 3);
            g.drawLine((int) m_y1CornerXYZPlane.GetX(), (int) m_y1CornerXYZPlane.GetY(), (int) m_y2CornerXYZPlane.GetX(), (int) m_y2CornerXYZPlane.GetY());
            g.drawString("Z", (int) m_x2CornerXYZPlane.GetX() + 5, (int) m_y1CornerXYZPlane.GetY());
            g.drawLine((int) m_x2CornerXYZPlane.GetX(), (int) m_y1CornerXYZPlane.GetY(), (int) m_x1CornerXYZPlane.GetX(), (int) m_y2CornerXYZPlane.GetY());

            g.drawLine((int) x1CenterPlane.GetX(), (int) x1CenterPlane.GetY(), (int) x2CenterPlane.GetX(), (int) x2CenterPlane.GetY());
            g.drawLine((int) y1CenterPlane.GetX(), (int) y1CenterPlane.GetY(), (int) y2CenterPlane.GetX(), (int) y2CenterPlane.GetY());
         }

         private void drawP1P2Points(Graphics g)
         {
            g.setColor(Color.ORANGE);

            g.drawString("P1", (int) m_arbitraryP1Point.GetX(), (int) m_arbitraryP1Point.GetY());
            g.drawString("P2", (int) m_arbitraryP2Point.GetX(), (int) m_arbitraryP2Point.GetY());
         }

         //Translation can be performed either with animation or straight away
         private void Translate()
         {
            if (m_primitives.size() > 0)
            {
               if (AdditionalAnimation.isSelected())
               {
                  if (m_translateX > 0 || m_translateY > 0 || m_translateZ > 0)
                  {
                     if (m_translateX != 0)
                     {
                        for (int i = 0; i < m_primitives.get(m_selectedPolygonID).getVerticies().length; i++)
                        {
                           m_primitives.get(m_selectedPolygonID).getVerticies()[i] = g_MY_MATH_LIB.Transalte(m_primitives.get(m_selectedPolygonID).getVerticies()[i], 1, 0, 0);
                        }
                        m_translateX--;
                     }
                     else if (m_translateY != 0)
                     {
                        for (int i = 0; i < m_primitives.get(m_selectedPolygonID).getVerticies().length; i++)
                        {
                           m_primitives.get(m_selectedPolygonID).getVerticies()[i] = g_MY_MATH_LIB.Transalte(m_primitives.get(m_selectedPolygonID).getVerticies()[i], 0, 1, 0);
                        }
                        m_translateY--;
                     }
                     else if (m_translateZ != 0)
                     {
                        for (int i = 0; i < m_primitives.get(m_selectedPolygonID).getVerticies().length; i++)
                        {
                           m_primitives.get(m_selectedPolygonID).getVerticies()[i] = g_MY_MATH_LIB.Transalte(m_primitives.get(m_selectedPolygonID).getVerticies()[i], 0, 0, 1);
                        }
                        m_translateZ--;
                     }
                  }
                  else
                  {
                     if (m_translateX != 0)
                     {
                        for (int i = 0; i < m_primitives.get(m_selectedPolygonID).getVerticies().length; i++)
                        {
                           m_primitives.get(m_selectedPolygonID).getVerticies()[i] = g_MY_MATH_LIB.Transalte(m_primitives.get(m_selectedPolygonID).getVerticies()[i], -1, 0, 0);
                        }
                        m_translateX++;
                     }
                     else if (m_translateY != 0)
                     {
                        for (int i = 0; i < m_primitives.get(m_selectedPolygonID).getVerticies().length; i++)
                        {
                           m_primitives.get(m_selectedPolygonID).getVerticies()[i] = g_MY_MATH_LIB.Transalte(m_primitives.get(m_selectedPolygonID).getVerticies()[i], 0, -1, 0);
                        }
                        m_translateY++;
                     }
                     else if (m_translateZ != 0)
                     {
                        for (int i = 0; i < m_primitives.get(m_selectedPolygonID).getVerticies().length; i++)
                        {
                           m_primitives.get(m_selectedPolygonID).getVerticies()[i] = g_MY_MATH_LIB.Transalte(m_primitives.get(m_selectedPolygonID).getVerticies()[i], 0, 0, -1);
                        }
                        m_translateZ++;
                     }
                  }
               }
               else
               {
                  for (int i = 0; i < m_primitives.get(m_selectedPolygonID).getVerticies().length; i++)
                  {
                     m_primitives.get(m_selectedPolygonID).getVerticies()[i] = g_MY_MATH_LIB.Transalte(m_primitives.get(m_selectedPolygonID).getVerticies()[i],
                             m_translateX,//Integer.parseInt(comXpositionSpinner.getValue().toString()),
                             m_translateY,//Integer.parseInt(comYpositionSpinner.getValue().toString()),
                             m_translateZ);//Integer.parseInt(comZpositionSpinner.getValue().toString()));
                  }
                  m_translateX = 0;
                  m_translateY = 0;
                  m_translateZ = 0;
               }
            }
         }

         private void scale()
         {
            if (m_primitives.size() > 0)
            {
               float cX = (m_primitives.get(m_selectedPolygonID).getVerticies()[1].GetX() + m_primitives.get(m_selectedPolygonID).getVerticies()[0].GetX()) / 2;
               float cY = (m_primitives.get(m_selectedPolygonID).getVerticies()[0].GetY() + m_primitives.get(m_selectedPolygonID).getVerticies()[3].GetY()) / 2;
               float cZ = (m_primitives.get(m_selectedPolygonID).getVerticies()[0].GetZ() + m_primitives.get(m_selectedPolygonID).getVerticies()[3].GetZ()) / 2;

               if (m_scaleUp)
               {
                  for (int i = 0; i < m_primitives.get(m_selectedPolygonID).getVerticies().length; i++)
                  {
                     m_primitives.get(m_selectedPolygonID).getVerticies()[i] = g_MY_MATH_LIB.transform3DScale(m_primitives.get(m_selectedPolygonID).getVerticies()[i], 1.1f, 1.1f, 0f, cX, cY, cZ);
                  }

                  m_scaleUp = false;
               }

               if (m_scaleDown)
               {
                  for (int i = 0; i < m_primitives.get(m_selectedPolygonID).getVerticies().length; i++)
                  {
                     m_primitives.get(m_selectedPolygonID).getVerticies()[i] = g_MY_MATH_LIB.transform3DScale(m_primitives.get(m_selectedPolygonID).getVerticies()[i], 0.9f, 0.9f, 0.9f, cX, cY, cZ);
                  }

                  m_scaleDown = false;
               }
            }
         }

         private void rotateAroundArbitraryAxis()
         {
            if (!arbitraryXaxisCheckBox.isSelected() && (Integer.parseInt(P2Xspinner.getValue().toString()) != 0))
            {
               m_arbitraryP2Point.SetX(0);
            }
            if (!arbitraryYaxisCheckBox.isSelected() && (Integer.parseInt(P2Yspinner.getValue().toString()) != 0))
            {
               m_arbitraryP2Point.SetY(0);
            }
            if (!arbitraryZaxisCheckBox.isSelected() && (Integer.parseInt(P2Zspinner.getValue().toString()) != 0))
            {
               m_arbitraryP2Point.SetZ(0);
            }

            //work out the arbitrary matrix first and after apply it to each point
            float[][] arbitraryMatrix = g_MY_MATH_LIB.rotateAroundArbitraryAxis(m_arbitraryP1Point, m_arbitraryP2Point, m_arbitraryRotationDegree, false);

            for (Primitive polygon : m_primitives)
            {
               for (int i = 0; i < polygon.getVerticies().length; i++)
               {
                  polygon.getVerticies()[i] = g_MY_MATH_LIB.multiplyVector3WithMatrix4by4(polygon.getVerticies()[i], arbitraryMatrix);
               }
            }
         }
      }
   }

   private void applyArbitraryPoints()
   {
      m_arbitraryP1Point = new Vector3(Float.parseFloat(P1Xspinner.getValue().toString()), Float.parseFloat(P1Yspinner.getValue().toString()), Float.parseFloat(P1Zspinner.getValue().toString()));

      m_arbitraryP2Point = new Vector3(Float.parseFloat(P2Xspinner.getValue().toString()), Float.parseFloat(P2Yspinner.getValue().toString()), Float.parseFloat(P2Zspinner.getValue().toString()));

      m_arbitraryRotationDegree = Float.parseFloat(ArbitraryDegreeSpinner.getValue().toString());
   }
   //Java Automatically Generated Code
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JCheckBox AdditionalAnimation;
   private javax.swing.JButton ApplyArbitraryPoints;
   private javax.swing.JButton ApplyNewPosition;
   private javax.swing.JPanel ArbitraryAnimationPanel;
   private javax.swing.JSpinner ArbitraryDegreeSpinner;
   private javax.swing.JMenu FileMenuBarItem;
   private javax.swing.JPanel LighViewPanel;
   private javax.swing.JSpinner P1Xspinner;
   private javax.swing.JSpinner P1Yspinner;
   private javax.swing.JSpinner P1Zspinner;
   private javax.swing.JSpinner P2Xspinner;
   private javax.swing.JSpinner P2Yspinner;
   private javax.swing.JSpinner P2Zspinner;
   private javax.swing.JPanel PolygonSelection;
   public static javax.swing.DefaultListModel RK4ResultList;
   private javax.swing.JPanel SettingsPanel;
   private javax.swing.JMenu ShowMenuBarItem;
   private javax.swing.JCheckBoxMenuItem ShowRenderWindowCheckBox;
   private javax.swing.JCheckBox ShowXYZPLaneCheckBox;
   private javax.swing.JPanel TransformationsPanel;
   private javax.swing.JPanel Visuals;
   private javax.swing.JButton addNewLightButton;
   public static javax.swing.JSlider ambientLightSlider;
   private javax.swing.JSlider animationSpeed;
   private javax.swing.JCheckBox arbitraryXaxisCheckBox;
   private javax.swing.JCheckBox arbitraryYaxisCheckBox;
   private javax.swing.JCheckBox arbitraryZaxisCheckBox;
   private javax.swing.JCheckBox bumpMapCheckBox;
   private javax.swing.ButtonGroup buttonGroup1;
   private javax.swing.JSpinner comXpositionSpinner;
   private javax.swing.JSpinner comYpositionSpinner;
   private javax.swing.JSpinner comZpositionSpinner;
   private javax.swing.JSlider distanceConstantSlider;
   private javax.swing.JMenuItem exitProgramButton;
   private javax.swing.JComboBox interfaceColors;
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JButton jButton3;
   private javax.swing.JButton jButton4;
   private javax.swing.JButton jButton6;
   private javax.swing.JColorChooser jColorChooser1;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel10;
   private javax.swing.JLabel jLabel11;
   private javax.swing.JLabel jLabel12;
   private javax.swing.JLabel jLabel13;
   private javax.swing.JLabel jLabel14;
   private javax.swing.JLabel jLabel15;
   private javax.swing.JLabel jLabel16;
   private javax.swing.JLabel jLabel17;
   private javax.swing.JLabel jLabel18;
   private javax.swing.JLabel jLabel19;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel20;
   private javax.swing.JLabel jLabel21;
   private javax.swing.JLabel jLabel22;
   private javax.swing.JLabel jLabel23;
   private javax.swing.JLabel jLabel24;
   private javax.swing.JLabel jLabel25;
   private javax.swing.JLabel jLabel26;
   private javax.swing.JLabel jLabel27;
   private javax.swing.JLabel jLabel28;
   private javax.swing.JLabel jLabel29;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JLabel jLabel9;
   private javax.swing.JMenuBar jMenuBar1;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel10;
   private javax.swing.JPanel jPanel11;
   private javax.swing.JPanel jPanel12;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JPanel jPanel3;
   private javax.swing.JPanel jPanel4;
   private javax.swing.JPanel jPanel5;
   private javax.swing.JPanel jPanel6;
   private javax.swing.JPanel jPanel7;
   private javax.swing.JPanel jPanel8;
   private javax.swing.JPanel jPanel9;
   private javax.swing.JTabbedPane jTabbedPane1;
   private javax.swing.JTabbedPane jTabbedPane2;
   private javax.swing.JCheckBox lightOnOffCheckBox;
   private javax.swing.JButton playPauseButton;
   private javax.swing.JSpinner polygonSelectionSpinner;
   private javax.swing.JButton removeSelectedLightButton;
   private javax.swing.JButton resetButton;
   private javax.swing.JButton scaleDownButton;
   private javax.swing.JButton scaleUpButton;
   private javax.swing.JCheckBox scanLineCheckBox;
   private javax.swing.JSpinner selectedLightIDSpinner;
   private javax.swing.JSlider selectedLightXPosition;
   private javax.swing.JSlider selectedLightYPosition;
   private javax.swing.JSlider selectedLightZPosition;
   private javax.swing.JComboBox selectedPolygonBumpMapComboBox;
   private javax.swing.JSlider selectedPolygonBumpMapStrengthtSlider;
   private javax.swing.JSlider selectedPolygonDiffuseCoefficientSlider;
   private javax.swing.JButton selectedPolygonRemoveButton;
   private javax.swing.JSlider selectedPolygonSpecularCoefficientSlider;
   private javax.swing.JComboBox selectedPolygonTextureComboBox;
   private javax.swing.JCheckBox showAllLightsCheckBox;
   private javax.swing.JCheckBox showP1P2PointsCheckBox;
   private javax.swing.JSlider specularReflectionConstantSlider;
   private javax.swing.JCheckBox textureCheckBox;
   private javax.swing.JPanel translateDownButton;
   private javax.swing.JButton translateLeftButton;
   private javax.swing.JButton translateRightButton;
   private javax.swing.JButton translateUpButton;
   private javax.swing.JSlider viewPointXSlider;
   private javax.swing.JCheckBox viewPointXYZCheckBox;
   private javax.swing.JSlider viewPointYSlider;
   private javax.swing.JSlider viewPointZSlider;
   // End of variables declaration//GEN-END:variables
}
