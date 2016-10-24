//package game.main;
//
//
//import java.awt.event.ActionEvent;
//
//public class test {
//    public void actionPerformed(ActionEvent ae)
//    {      s1=text3.getText();
//        try
//        {
//            if(ae.getSource()==b1)
//            {
//                h=Integer.parseInt(s1);
//                labels1=new JLabel[h];
//                tfs1 = new JTextField[h];
//                labels2=new JLabel[h];
//                tfs2=new JTextField[h];
//
//                for(int i=0;i<h;i++)
//                {
//                    setLayout(null);
//                    labels1[i]=new JLabel("enter the name of  "+ (i+1) + "actor");
//                    tfs1[i] = new JTextField(10);
//                    labels2[i]=new JLabel("enter the number of actions of  "+ (i+1) + "actor");
//                    tfs2[i] = new JTextField(10);
//                    for(int j=100;j<=1;j+=20)
//                     {
//                        labels1[i].setBounds(100, j, 250, 20);
//                        labels2[i].setBounds(100, j, 250, 20);
//                        panel.add(tfs1[i]);
//                        panel.add(tfs2[i]);
//                        add(panel);
//                        add(labels1[i]);
//                    }   add(labels2[i]);
//                }
//            }
//        }
//    catch(Exception e)
//        {
//            System.out.println("exception"+ e);
//        }
//    }
//}
