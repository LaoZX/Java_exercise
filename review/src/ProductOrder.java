     import java.util.*;
     import java.awt.*;
     import java.awt.event.*;
     import javax.swing.*;
     import javax.swing.event.*;


    class SortableDataStore  implements Comparable<SortableDataStore> { 
       protected String productItem, noItem, orderInfo;
       public SortableDataStore() {
         productItem = null;  
	      noItem = null; 
	      orderInfo = null; 
       }
       public SortableDataStore(String p, String n, String o) {
         productItem=p;
         noItem=n;
         orderInfo=o;
       }
       public String toString() {
         return new String(productItem + ", " + noItem + ", " + orderInfo) ;
       }

       // fill in the area to implement Comparable interface 
       public int compareTo(SortableDataStore s){
         if(this.productItem.compareTo(s.productItem)>0){return 1;}
         else if(this.productItem.compareTo(s.productItem)==0){
            return this.noItem.compareTo(s.noItem);
         }
         else {return -1;}
       }

    } // end of DataStore


/******
   This provides only the sample code for Java GUI shape.
   You should fill in all the code for envent handling and other operation.
*****/
public class ProductOrder extends JFrame {
  	   protected String list_Contents, noOrder, orderInfo;
	   protected SortableDataStore[] cartData = new SortableDataStore[20];

        protected JPanel topp, leftp, rightp,bottomp,centerup, centerdown;
        protected JButton putb, showb, sortb, clearb;
        protected JLabel title, noorder, orderinfo;
        protected JList<String> plist;
        protected JTextField nofield, infofield;
        protected JTextArea contentsarea;
        protected String[] data = {"IBM NoteBook", "Dell Product", "MS Windows", "Sun Workstation", "Oracle DB", "MySQL"};
        protected int idx = 0;
        //protected int lastIndex = -1;

       public ProductOrder() {
        getContentPane().setLayout(new BorderLayout());
        topp = new JPanel();           //title
        leftp = new JPanel();          //product name
        rightp = new JPanel();         //place centerup & down
        bottomp = new JPanel();        //"show cart" button
        centerup = new JPanel();       //show output
        centerdown = new JPanel();     //3 buttons

        getContentPane().add(topp, "North");
        getContentPane().add(leftp, "West");
        getContentPane().add(rightp, "Center");
        getContentPane().add(bottomp, "South");

        title = new JLabel("Product Order");
        title.setFont(new Font("Product Order",Font.BOLD, 20));
        topp.add(title);

        plist = new JList<String>(data);
        plist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        plist.addListSelectionListener(e->list_Contents = plist.getSelectedValue().toString());
        leftp.add(plist);

   	noorder = new JLabel("No. of Order Items");
   	orderinfo = new JLabel("Order Information");
	   nofield = new JTextField();
	   infofield = new JTextField();

	   putb = new JButton("Put into Cart");
   	putb.addActionListener(e->{   
         noOrder = nofield.getText();
         orderInfo = infofield.getText();
         cartData[idx]=new SortableDataStore(list_Contents, noOrder, orderInfo);
         idx++; 
      });
	   sortb = new JButton("Sort Items");
   	sortb.addActionListener(e->{
         Arrays.sort(cartData,0,idx);
        //can't use sort(cartData) since cartData's size is not stable
        contentsarea.setText("");;
        for(int i=0;i<idx;i++){
           contentsarea.append(cartData[i].toString()+"\n");
        }
      });
	   clearb = new JButton("Reset Cart");
   	clearb.addActionListener(rset->{
         idx = 0;
         contentsarea.setText("");
      });

	   centerup.setLayout(new GridLayout(2,2));
	   centerup.add(noorder);
	   centerup.add(orderinfo);
	   centerup.add(nofield);
	   centerup.add(infofield);
	   centerdown.setLayout(new GridLayout(1,2));
	   centerdown.add(putb);
	   centerdown.add(sortb);
	   centerdown.add(clearb);

	   rightp.setLayout(new GridLayout(2,1));
	   rightp.add(centerup);
	   rightp.add(centerdown);

	   showb = new JButton("Show Cart");
   	showb.addActionListener(show3->{
         contentsarea.setText("");
         for(int i=0;i<idx;i++){
            contentsarea.append(cartData[i].toString()+"\n");
         }
      });

	   contentsarea = new JTextArea(10,1);
	   bottomp.setLayout(new GridLayout(1,2));
	   bottomp.add(showb);
	   bottomp.add(contentsarea);

   }  // Product Order constructor



/*****
Fill in code for event listeners.
You can use inner classes for the listeners.
*****/
   /*public class ProductItemListener implements ListSelectionListener{
      public void valueChanged(ListSelectionEvent le){
         list_Contents = plist.getSelectedValue().toString();
      }
   }*/

   /*public class PutButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent pe){
         noOrder = nofield.getText();
		   orderInfo = infofield.getText();
         cartData[idx]=new SortableDataStore(list_Contents, noOrder, orderInfo);
         idx++;
      }
   }*/

   /*public class SortButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent ste){
        Arrays.sort(cartData,0,idx);
        //can't use sort(cartData) since cartData's size is not stable
        contentsarea.setText("");;
        for(int i=0;i<idx;i++){
           contentsarea.append(cartData[i].toString()+"\n");
        }
      }
   }*/

   /*class ResetButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent rsete) {
         idx = 0;
         contentsarea.setText("");
       }
   }*/

   /*class ShowButtonListener implements ActionListener {
       public void actionPerformed(ActionEvent showe) {
         contentsarea.setText("");
         for(int i=0;i<idx;i++){
            contentsarea.append(cartData[i].toString()+"\n");
         }
      }
   }*/

   public static void main (String args[]) {
            ProductOrder f = new ProductOrder();
            f.setTitle("Product Order");
            f.setSize(500,400);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        }
} // end of ProductOrder
     
