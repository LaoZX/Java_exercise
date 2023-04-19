Create a window showing a central display and 6 buttons. The display has a border.

    Requirements:

     - class name: ExGUISwing_01 (file name: ExGUISwing_01.java)

     - super class: JFrame

    Comments:

     - Import javax.swing.JFrame class and other neccesary classes at the beginning of your file.

     - Use a JButton object for each button

     - Use a JPanel object and a BevelBorder object for the central display

     - For showing text on the central display, use a JLabel object

     - Create above JButton, JLabel and JPanel objects as attributes for futher use.

     - In the constructor:
        (1) Call the constructor of JFrame with a title string.
        (2) Set the initial size of the window (by setSize() of JFrame) .
        (3) Call the setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) for termination of the program when the window is closed.
        (4) Remove the layout managers of JFrame and JPanel objects by calling their setLayout(null).
              (This is to control the location and the size of the buttons and text by ourselves)
        (5) For each created object:
            Set the size (use setSize() method).
            Set the location (use setLocation() method).
        (6) For the JPanel object:
             Create a BevelBorder object and set it to the JPanel by its setBorder() method.
        (7) For the JLabel object:
             Create a Font object and set it to the JLabel (use setFont()).
             Change its foreground color to dark green.
        (8) Add the JButton and JPanel objects to the window (use add() method).
        (9) Add the JLabel object  to the JPanel object.

     - Implement the main() method:
        (1)  It must be the following format
             "public static void main(String argv[ ])".
        (2) Create a ExGUISwing_01 object.
        (3) Call its setVisible() with parameter "true".
        
        
        
        
        This is an extension of ExGUISwing_01. Clicking the buttons on the window can change the text on the central display and on-off other buttons.

    Requirements:

     - class name: ExGUISwing_02 (file name: ExGUISwing_02.java)

     - super class: ExGUISwing_01 (You should finish Step 2 before you try this step)

     - implement interface: ActionListener to catch button events.

    Comments:

     - Use another JLabel object as an attribute to show "AM" or "FM" on the central display.

     - Use attributes to save necessary information.

     - Implement the constructor:
           (1) locate the new JLabel object on the central display (JPanel object);
           (2) add listeners (this) to all the buttons.
     - Implement actionPerformed() for ActionListener:

     - To on-off a button use setVisible() method.

     - To change the text on a JLabel, use setText() method.
