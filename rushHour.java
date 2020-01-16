//Khubi Shah, June 10, 2016
// Project 2- Grade 10 Computer Science- Rush Hour
// Teacher: Ms. Gorski
// all grid pictures, pictures for instructions, game title: borrowed from ThinkFun's online version of RushHour- http://www.thinkfun.com/play-online/rush-hour/
// car buttons for screens: John Raynolds- www.clipartpanda.com
// skyline: Max Brown- www.etsy.com
// main menu taxi: Patricia Karen- www.yellowcabnyctaxi.com
// arrows: Paul Green- www.freestockphotos.biz
// reset,next,play again button shapes: Daniella Fonction- www.iconarchive.com
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import java.applet.Applet; 

public class rushHour extends Applet implements ActionListener 
{      
  Panel a, overall, gamepart, main, help, instructions, game;
  CardLayout cdLayout = new CardLayout();
  int row=6;
  int level=0;
  int prog=0;
  JCheckBox s1,s2,s3,s4,s5;
  JComboBox levels;
  JProgressBar progress;
  JRadioButton story, seeinstruct;
  boolean lvl1won=false;
  boolean lvl2won=false;
  boolean lvl3won=false;
  boolean lvl4won=false;
  boolean lvl5won=false;
  boolean lvl6won=false;
  boolean lvl7won=false;
  boolean lvl8won=false;
  boolean lvl9won=false;
  boolean lvl10won=false;
  int counter=-1;
  int temp,x,y;
  Panel control, colorstat;
  int choice;
  JLabel colorstatus, pig, levellabel, leveltitle, movesdisplay;
  JButton buttons[]= new JButton [36], up,down,left,right,next,reset,again;
  char colour[][]={{'n', 'n', 'g', 'n', 'o', 'o'},  {'n', 'n', 'g', 'n', 'n', 'n'},  {'n', 'b', 'r', 'r', 'm', 'n'},  {'n', 'b', 'n', 'n', 'm', 'y'}, {'l', 'l', 'l', 'n', 'p', 'y'},  {'n', 'n', 'n', 'n', 'p', 'y'} };
  int num[][]={{0,0,1,0,1,2}, {0,0,2,0,0,0}, {0,1,1,2,1,0}, {0,2,0,0,2,1}, {1,2,3,0,1,2}, {0,0,0,0,2,3}};  
  char colLevels[][][]={{{'n', 'n', 'g', 'n', 'o', 'o'},  {'n', 'n', 'g', 'n', 'n', 'n'},  {'n', 'b', 'r', 'r', 'm', 'n'},  {'n', 'b', 'n', 'n', 'm', 'y'}, {'l', 'l', 'l', 'n', 'p', 'y'},  {'n', 'n', 'n', 'n', 'p', 'y'} },{{'n', 'n', 'n', 'g', 'o', 'o'}, {'n', 'n', 'n', 'g', 'n', 'n'}, {'n', 'r', 'r', 'b', 'n', 'n'}, {'l', 'l', 'l', 'b', 'n', 'y'}, {'n', 'n', 'm', 'u', 'u', 'y'}, {'n', 'n', 'm', 'n', 'n', 'y'}},{{'n', 'o', 'o', 'g', 'y', 'n'}, {'n', 'n', 'n', 'g', 'y', 'n'}, {'n', 'r', 'r', 'n', 'y', 'd'}, {'n', 'n', 'n', 'n', 'n', 'd'}, {'n', 'n', 'b', 'u', 'u', 'd'}, {'n', 'n', 'b', 'l', 'l', 'l'}},{{'n', 'n', 'n', 'n', 'n', 'n'}, {'n', 'n', 'n', 'n', 'n', 'y'}, {'n', 'n', 'n', 'r', 'r', 'y'}, {'u', 'u', 'n', 'd', 'n', 'y'}, {'n', 'b', 'n', 'd', 'o', 'o'}, {'n', 'b', 'n', 'd', 'n', 'n'}}, {{'n', 'n', 'n', 'y', 'n', 'n'}, { 'n', 'n', 'n', 'y', 'n', 'd'}, { 'r', 'r', 'n', 'y', 'n', 'd'}, { 'n', 'n', 'n', 'n', 'n', 'd'}, { 'n', 'b', 'o', 'o', 'n', 'n'}, { 'n', 'b', 'n', 'u', 'u', 'n'}},{{'u','u','y','o','o','b'}, {'d','n','y','n','n','b'}, {'d','n','y','r','r','p'}, {'d','q','q','m','n','p'}, {'n','n','n','m','i','i'}, {'n','n','n','n','n','n'}},{{'y', 'n', 'l', 'l', 'l', 'g'}, {'y', 'n', 'n', 'n', 'n', 'g'}, {'y', 'n', 'r', 'r', 'd', 'm'}, {'s', 's', 's', 'n', 'd', 'm'}, {'n', 'n', 'b', 'n', 'd', 'n'}, {'o', 'o', 'b', 'n', 'u', 'u'}},{{'n', 'n', 'n', 'g', 'o', 'o'}, {'n', 'n', 'n', 'g', 'n', 'n'}, {'n', 'r', 'r', 'b', 'n', 'n'}, {'l', 'l', 'l', 'b', 'n', 'y'}, {'n', 'n', 'm', 'u', 'u', 'y'}, {'n', 'n', 'm', 'n', 'n', 'y'}},{{'n', 'n', 'n', 'n', 'n', 'n'}, {'n', 'n', 'n', 'n', 'n', 'n'}, {'r', 'r', 'y', 'n', 'n', 'n'}, {'u', 'u', 'y', 'n', 'd', 'n'}, {'n', 'p', 'y', 'n', 'd', 'n'}, {'n', 'p', 'o', 'o', 'd', 'n'}},{{'o', 'o', 'p', 'y', 'n', 'n'}, {'n', 'n', 'p', 'y', 'n', 'n'}, {'r', 'r', 'n', 'y', 'n', 'd'}, {'n', 'n', 'n', 'n', 'n', 'd'}, {'n', 'g', 'i', 'i', 'n', 'd'}, {'n', 'g', 'n', 'l', 'l', 'l'}}};
  int numLevels[][][]={{{0,0,1,0,1,2}, {0,0,2,0,0,0}, {0,1,1,2,1,0}, {0,2,0,0,2,1}, {1,2,3,0,1,2}, {0,0,0,0,2,3}}, {{0,0,0,1,1, 2},  {0,0,0,2,0,0},  {0,1,2,1,0,0},  {1,2,3,2,0,1},  {0,0,1,1,2,2},  {0,0,2,0,0,3}},{{0,1,2,1,1,0}, {0,0,0,2,2,0}, {0,1,2,0,3,1}, {0,0,0,0,0,2}, {0,0,1,1,2,3}, {0,0,2,1,2,3}},{{0,0,0,0,0,0}, {0,0,0,0,0,1}, { 0,0,0,1,2,2}, {1,2,0,1,0,3}, {0,1,0,2,1,2}, {0,2,0,3,0,0}},{{0,0,0,1,0,0}, {0,0,0,2,0,1}, {1,2,0,3,0,2}, {0,0,0,0,0,3}, {0,1,1,2,0,0}, {0,2,0,1,2,0}},{{1, 2, 1, 1, 2, 1}, {1, 0, 2, 0, 0, 2}, {2, 0, 3, 1, 2, 1}, {3, 1, 2, 1, 0, 2}, {0, 0, 0, 2, 1, 2}, {0, 0, 0, 0, 0, 0}},{{1, 0, 1, 2, 3, 1}, {2, 0, 0, 0, 0, 2}, {3, 0, 1, 2, 1, 1}, {1, 2, 3, 0, 2, 2}, {0, 0, 1, 0, 3, 0}, {1, 2, 2, 0, 1, 2}},{{0, 0, 0, 1, 1, 2}, {0, 0, 0, 2, 0, 0}, {0, 1, 2, 1, 0, 0}, {1, 2, 3, 2, 0, 1}, {0, 0, 1, 1, 2, 2}, {0, 0, 2, 0, 0, 3}},{{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {1, 2, 1, 0, 0, 0}, {1, 2, 2, 0, 1, 0}, {0, 1, 3, 0, 2, 0}, {0, 2, 1, 2, 3, 0}},{{1, 2, 1, 1, 0, 0}, {0, 0, 2, 2, 0, 0}, {1, 2, 0, 3, 0, 1}, {0, 0, 0, 0, 0, 2}, {0, 1, 1, 2, 0, 3}, {0, 2, 0, 1, 2, 3}}};
  char currentcolour='n';
  String inlvls[]={"Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6", "Level 7", "Level 8", "Level 9", "Level 10"};
  int topx=0;
  int topy=0;
  int rightx=0;
  int righty=0;
  int leftx=0;
  int lefty=0;
  int downx=0;
  int moves=0;
  int downy=0;
  String chosen;
  Color slategrey = new Color (70,67,61);
  
  public void init ()    
  { 
    resize(1280,800);
    overall= new Panel();
    overall.setLayout (cdLayout);
    setLayout(new BorderLayout());
    add ("Center",overall);
    screen1();//main menu
    screen2();// instructions page
    screen3();// game screen
    screen4(); //tips
    setBackground(new Color(183,183,183));   
  }
  
  public void screen1()//home
  {   
    main= new Panel();
    JLabel bigtitle= new JLabel(createImageIcon("titlepiece.jpg"));
    bigtitle.setPreferredSize(new Dimension(800,300));
    main.add(bigtitle);
    Panel buttonholder= new Panel(new GridLayout(1,3));
    main.setBackground(new Color(70,67,61));
    JButton gamescreen= new JButton(createImageIcon("playbutton.jpg"));
    gamescreen.setBorderPainted(false);
    gamescreen.addActionListener(this);
    gamescreen.setPreferredSize(new Dimension(350,100));
    gamescreen.setActionCommand("screen3");
    JButton helpme= new JButton(createImageIcon("helpbutton.jpg"));
    helpme.setBorderPainted(false);
    helpme.addActionListener(this);
    helpme.setPreferredSize(new Dimension(350,100));
    helpme.setActionCommand("screen4");  
    JButton whattodo= new JButton(createImageIcon("instructions.jpg"));
    whattodo.setBorderPainted(false);
    whattodo.setBorderPainted(false);
    whattodo.addActionListener(this);
    whattodo.setPreferredSize(new Dimension(350,100));
    whattodo.setActionCommand("screen2");
    buttonholder.add(gamescreen);
    buttonholder.add(whattodo);
    buttonholder.add(helpme);   
    main.add(buttonholder);    
    JLabel skyline= new JLabel(createImageIcon("skyline.jpg"));
    skyline.setPreferredSize(new Dimension(1290,145));
    main.add(skyline);    
    overall.add("screen1",main);
  }
  
  public void screen2()//insructions
  {
    
    instructions= new Panel();
    instructions.setBackground(slategrey);
    JButton gamescreen= new JButton(createImageIcon("playbutton.jpg"));
    gamescreen.addActionListener(this);
    gamescreen.setPreferredSize(new Dimension(350,100));
    gamescreen.setActionCommand("screen3");
    
    JButton gohome= new JButton(createImageIcon("mainmenubutton.jpg"));
    gohome.setPreferredSize(new Dimension(350,100));
    gohome.addActionListener(this);
    gohome.setActionCommand("screen1");
    
    Panel radio= new Panel();
    ButtonGroup options= new ButtonGroup();
    story= new JRadioButton(createImageIcon("backgroundstory.jpg"));
                            story.addActionListener(this);
                            story.setPreferredSize(new Dimension(445,200));
                            story.setActionCommand("background");
                            radio.add(story);
    seeinstruct= new JRadioButton(createImageIcon("radioinstructions.jpg"));
                            seeinstruct.addActionListener(this);
                            seeinstruct.setPreferredSize(new Dimension(600,200));
                            seeinstruct.setActionCommand("seeinstruct");
                            radio.add(seeinstruct);    
    pig= new JLabel("");
    pig.setVerticalAlignment(SwingConstants.CENTER);     
    instructions.add(gohome);
    instructions.add(gamescreen);
    instructions.add(radio);
    instructions.add(pig);
    overall.add("screen2",instructions); 
  }
  
  public void screen3()//game screen
  {
    game= new Panel();
    game.setBackground(slategrey);
    Panel buttonholder= new Panel(new GridLayout(1,3));
    buttonholder.setBackground(slategrey);
    JButton gohome= new JButton(createImageIcon("mainmenubutton.jpg"));
    gohome.setPreferredSize(new Dimension(350,100));
    gohome.addActionListener(this);
    gohome.setActionCommand("screen1");
    buttonholder.add(gohome);  
    JButton help= new JButton(createImageIcon("instructions.jpg"));
    help.setPreferredSize(new Dimension(350,100));
    help.addActionListener(this);
    help.setActionCommand("screen2");
    buttonholder.add(help);
    game.add(buttonholder);
    overall.add("screen3",game);
    Panel info= new Panel(new GridLayout(2,1));
    levellabel=new JLabel(createImageIcon("lvl1.jpg"));
    levellabel.setPreferredSize(new Dimension(236,46));
    info.add(levellabel);
    movesdisplay= new JLabel("0 Moves"); 
    movesdisplay.setForeground(new Color(255,143,23));
    movesdisplay.setFont( new Font("Helvetica Neue Bold", Font.PLAIN, 50));
    info.add(movesdisplay);
    game.add(info);
    combobox();
    gamepart= new Panel();  
    gridpart();    
    controlpanel();    
    threebuttons();
    progressbar();   
  }
  
  public void combobox()
  {
    levels= new JComboBox (inlvls);
    levels.setSelectedIndex(0);
    levels.addActionListener(this);
    levels.setActionCommand("change");
    chosen="Level 1";
    game.add(levels);
  }
  
  public void screen4()
  {
    help= new Panel();
    help.setBackground(slategrey);
    Panel buttonholder=new Panel();
    JButton backhome= new JButton(createImageIcon("mainmenubutton.jpg"));
   backhome.setPreferredSize(new Dimension(350,100));
   backhome.addActionListener(this);
   backhome.setActionCommand("screen1");
   JButton play= new JButton(createImageIcon("playbutton.jpg"));
   play.setPreferredSize(new Dimension(350,100));
   play.addActionListener(this);
   play.setActionCommand("screen3");  
    Panel checks= new Panel(new GridLayout(6,1));
    checks.setForeground(Color.white);
    JLabel skills= new JLabel("Self-Assess: Do you do the following when playing?");
    skills.setFont(new Font("Helvetica Neue Bold", Font.PLAIN, 40));
    skills.setVerticalAlignment(SwingConstants.CENTER);  
    skills.setForeground(new Color(248,102,6));
    s1= new JCheckBox ("Try to think backwards from the solution to the problem");   
    s1.setFont(new Font("Helvetica Neue Bold", Font.PLAIN, 20));
    s1.setForeground(new Color(255,246,250));
    s1.setVerticalAlignment(SwingConstants.CENTER);  
    s2= new JCheckBox ("Keep a cool mind when trying to solve a level");
    s2.setFont(new Font("Helvetica Neue Bold", Font.PLAIN, 20));
    s2.setForeground(new Color(255,246,250));
    s2.setVerticalAlignment(SwingConstants.CENTER);  
    s3= new JCheckBox ("Reset the grid when you feel stuck");
    s3.setFont(new Font("Helvetica Neue Bold", Font.PLAIN, 20));
    s3.setForeground(new Color(255,246,250));
    s3.setVerticalAlignment(SwingConstants.CENTER);  
    s4= new JCheckBox ("Ask others for help or reflect on what you did");
    s4.setVerticalAlignment(SwingConstants.CENTER);  
    s4.setFont(new Font("Helvetica Neue Bold", Font.PLAIN, 20));
    s4.setForeground(new Color(255,246,250));
    JLabel then= new JLabel("If you checked them all, all you need is only more practice!");
    then.setFont(new Font("Helvetica Neue Bold", Font.PLAIN, 40));
    then.setVerticalAlignment(SwingConstants.CENTER);  
    then.setForeground(new Color(248,102,6));
    buttonholder.add(backhome);
    buttonholder.add(play);
    help.add(buttonholder);
    checks.add(skills);
    checks.add(s1);
    checks.add(s2);
    checks.add(s3);
    checks.add(s4);
    checks.add(then);
    help.add(checks);
    overall.add("screen4", help);
  }
  public void progressbar()//JProgressBar
  {
    progress= new JProgressBar (0,1,100);
    progress.setValue(0);
    progress.setStringPainted(true);
    game.add(progress);
  }  
  public void gridpart()//the grid itself printed with a for loop after the values of the 2D array are set for each level 
  {
    a=new Panel(new GridLayout(6,6));
    int move = 0;  
    for (int i = 0 ; i < 6 ; i++)  //making array for display equal to the 3D arrays values for each level
    {      
      for (int j = 0 ; j < 6 ; j++)      
      { 
        colour [i][j]= colLevels[level][i][j];
        num [i][j]= numLevels[level][i][j];
      } 
    }    
    for (int i = 0 ; i < 6 ; i++)    //printing the array out in the JButton... 70 by 70 for square-like look
    {      
      for (int j = 0 ; j < 6 ; j++)      
      { 
        buttons[move]= new JButton (createImageIcon (colour [i] [j] + ""+num[i][j]+".jpg")); 
        buttons[move].setPreferredSize(new Dimension(70,70));
        buttons[move].addActionListener(this);
        buttons[move].setActionCommand(""+move);
        a.add(buttons[move]);
        move++; 
      } 
    } 
  }
  
  public void threebuttons()//reset,next,play again
  {
    Panel buttonholder2= new Panel(new GridLayout(1,3));
    buttonholder2.setBackground(slategrey);
    next= new JButton(createImageIcon("skip.jpg"));
    next.addActionListener(this);
    next.setBorderPainted(false);
    next.setPreferredSize(new Dimension(118,113));
    next.setActionCommand("skip");
    next.setVerticalAlignment(SwingConstants.CENTER);
    buttonholder2.add(next);    
    reset= new JButton (createImageIcon("reset.jpg"));
    reset.addActionListener(this);
    reset.setBorderPainted(false);
    reset.setVerticalAlignment(SwingConstants.CENTER);
    reset.setPreferredSize(new Dimension(118,113));
    reset.setActionCommand("reset");
    buttonholder2.add(reset); 
    again= new JButton(createImageIcon("again.jpg"));
    again.addActionListener(this);
    again.setBorderPainted(false);
    again.setVerticalAlignment(SwingConstants.CENTER);
    again.setPreferredSize(new Dimension(118,113));
    again.setActionCommand("again");
    buttonholder2.add(again);   
    game.add(buttonholder2);
  }
  public void controlpanel()//up,down,right,left arrows
  {
    control=new Panel(new GridLayout(3,3));
    control.setBackground(new Color(255,255,255));
    control.setPreferredSize(new Dimension(255,255));  
    JLabel blank= new JLabel (createImageIcon("blank.jpg"));
    blank.setPreferredSize(new Dimension(88,88));
    JLabel blank1= new JLabel (createImageIcon("blank.jpg"));
    blank1.setPreferredSize(new Dimension(88,88));
    JLabel blank3= new JLabel (createImageIcon("blank.jpg"));
    blank3.setPreferredSize(new Dimension(88,88));
    JLabel blank4= new JLabel (createImageIcon("blank.jpg"));
    blank4.setPreferredSize(new Dimension(88,88));   
    up= new JButton(createImageIcon("up.jpg"));
    up.setBorderPainted(false);
    up.setPreferredSize(new Dimension(88,88));
    up.setActionCommand("up");
    up.addActionListener(this);
    game.add(up);
    down= new JButton(createImageIcon("down.jpg"));
    down.setPreferredSize(new Dimension(88,88));
    down.setActionCommand("down");
    down.addActionListener(this);
    down.setBorderPainted(false);
    game.add(down);
    left= new JButton(createImageIcon("left.jpg"));
    left.setActionCommand("left");
    left.addActionListener(this);
    left.setBorderPainted(false);
    left.setPreferredSize(new Dimension(88,88));
    game.add(left);
    right= new JButton(createImageIcon("right.jpg"));
    right.setActionCommand("right");
    right.addActionListener(this);
    right.setPreferredSize(new Dimension(88,88));
    right.setBorderPainted(false);
    game.add(right);    
    colorstatus= new JLabel (createImageIcon("colorblank.jpg"));
    colorstatus.setPreferredSize(new Dimension(167,167));  
    control.add(blank);
    control.add(up); 
    control.add(blank1);
    control.add(left);
    control.add(colorstatus);
    control.add(right);
    control.add(blank3);
    control.add(down);
    control.add(blank4);   
    gamepart.add(control);
    gamepart.add(a);
    game.add(gamepart);
  }
  public void redraw()//redraw the screen after any changes to array values
  {
    
    int move = 0;    
    
    
    for (int i = 0 ; i < 6 ; i++)    
    {      
      for (int j = 0 ; j < 6 ; j++)      
      {   
        buttons[move].setIcon(createImageIcon (colour [i] [j] + ""+num[i][j]+".jpg"));
        move++; 
      } 
    } 
  }
  public boolean updown()//make sure that the car they chose can actually move up and down
  {
    if (currentcolour=='y')
      return true;
    else if (currentcolour=='m')
      return true;
    else if (currentcolour=='p')
      return true;
    else if (currentcolour=='g')
      return true;
    else if (currentcolour=='b')
      return true;
    else if (currentcolour=='d')
      return true;
    else if (currentcolour=='p')
      return true;
    else
      return false;
    
  }
  public boolean leftright()//make sure the car they chose can actually move left and right
  {
    if (currentcolour=='o')
      return true;
    else if (currentcolour=='r')
      return true;
    else if (currentcolour=='l')
      return true;
    else if (currentcolour=='u')
      return true;
    else if (currentcolour=='i')
      return true;
    else if (currentcolour=='q')
      return true;
    else if (currentcolour=='s')
      return true;
    else if (currentcolour=='v')
      return true;
    else
      return false;
  } 
  public void findrightmost()//find the right most part of the car
  {
    for (int i=0; i<row; i++)
    {
      for(int j=0; j<row; j++)
      {
        if (currentcolour==colour[i][j])
        {
          if(currentcolour=='l'||currentcolour=='s'||currentcolour=='v')//if it is a truck
          {
            if(num[i][j]==3)
            {
              rightx=i;
              righty=j;
            }
          }
          else 
          {
            if(num[i][j]==2)
            {
              rightx=i;
              righty=j;
            }
          }
          
        }
        
      }
    }
    
  }  
  public void findleftmost()//find the left most piece of a car when they want to move left.
  {
    for (int i=0; i<row; i++)
    {
      for(int j=0; j<row; j++)
      {
        if (currentcolour==colour[i][j])
        {
          if(num[i][j]==1)
          {
            leftx=i;
            lefty=j;
          } 
        }
      }
    }  
  } 
  public void finddownmost()//find bottom most piece of the car when they want to move down
  {
    for (int i=row-1; i>=0; i--)
    {
      for(int j=row-1; j>=0; j--)
      {
        if (colour[i][j]==currentcolour)
        {
          if ((currentcolour=='d')||(currentcolour=='y'))
          {
            if (num[i][j]==3)
            {
              downx=i;
              downy=j;
              return;
            }
          }
          else 
          {
            if (num[i][j]==2)
            { 
              downx=i;
              downy=j;
              return;
            }
          }
          
        }
      }
    }
  }  
  public void findtopleft()//find top most piece of the car when they want to move up
  {
    for (int i=0; i<row; i++)
    {
      for(int j=0; j<row; j++)
      {
        if (colour[i][j]==currentcolour)
        {
          topx=i;
          topy=j;
          return;
        }
      }
    }
  } 
  public void actionPerformed (ActionEvent e) 
  {    
    if (e.getActionCommand().equals("background"))
    pig.setIcon(createImageIcon("storystory.jpg"));
      else if (e.getActionCommand().equals("seeinstruct"))
    pig.setIcon(createImageIcon("instructinstruct.jpg"));
    else if (e.getActionCommand ().equals ("screen1"))
      cdLayout.show(overall,"screen1");
    else if (e.getActionCommand ().equals ("screen2"))
      cdLayout.show(overall,"screen2");
    else if (e.getActionCommand ().equals ("screen3"))
      cdLayout.show(overall,"screen3");
    else if (e.getActionCommand ().equals ("screen4"))
      cdLayout.show(overall,"screen4");
    else if (e.getActionCommand().equals("reset")) 
      ontonext(); 
    else if (e.getActionCommand().equals("skip"))
    {
      level++; 
      ontonext();  //reset values of displayed array with 3D array, and then redraw it.
    }
    else if (e.getActionCommand().equals("change"))//using the combo box, player can see all levels
    {
     JComboBox cb = (JComboBox) e.getSource ();
     chosen = (String) cb.getSelectedItem ();
     adjustinglvl();//use String variable to determine what level player wants to go to and then switches grid and title pieces accordingly.
    }
    else if(e.getActionCommand().equals("again"))
      settingitalltozero();
    else if (e.getActionCommand().equals("up"))
      up();  
    else if (e.getActionCommand().equals("right"))
      right();    
    else if (e.getActionCommand().equals("left"))
      left();
    else if (e.getActionCommand().equals("down"))
      down();
    else
    {
      counter=Integer.parseInt(e.getActionCommand());//get the action command of the button.
      settingcolour(counter);      
    }  
    didWin();  //checks if the red car has crossed the traffic (reached the end of its row).
displayingmoves();// changes the JLabel that displays moves
  }    
  public void adjustinglvl()
  {
    if (chosen.equals("Level 1"))
          level=0;
    else if (chosen.equals("Level 2"))
      level=1;
    else if (chosen.equals("Level 3"))
      level=2;
    else if (chosen.equals("Level 4"))
      level=3;
    else if (chosen.equals("Level 5"))
      level=4;
    else if (chosen.equals("Level 6"))
      level=5;
    else if (chosen.equals("Level 7"))
      level=6;
    else if (chosen.equals("Level 8"))
      level=7;
    else if (chosen.equals("Level 9"))
      level=8;
    else if (chosen.equals("Level 10"))
      level=9;   
    ontonext();
    redraw();
  } 
  public void displayingmoves()// changes the JLabel that displays moves
  {
    if(moves==1)
      movesdisplay.setText(moves+" Move");//singular
    else
    movesdisplay.setText(moves+" Moves");//plural
  }  
  public void settingwontofalse() //a part of the restart game method... setting that the levels have not been won.
  {
    lvl1won=false;
    lvl2won=false;
    lvl3won=false;
    lvl4won=false;
    lvl5won=false;
    lvl6won=false;
    lvl7won=false;
    lvl8won=false;
    lvl9won=false;
    lvl10won=false;
  }  
  public void settingitalltozero()//a part of the restart game method
  {
    level=0; moves=0; prog=0; progress.setValue(prog);
      settingwontofalse();
      enablingbuttons();
      ontonext();
  }
  public void settingcolour(int counter)//find the piece selected and its action command divided and modded will give us the x and y coordinates. we store the color like this.
  { 
    x = counter / row; 
    y = counter % row; 
    if (colour[x][y]=='n')
      colorstatus.setIcon(createImageIcon("colorblank.jpg"));  
    else
    {
      colorstatus.setIcon(createImageIcon(""+colour[x][y]+".jpg"));
      colorstatus.setPreferredSize(new Dimension(170,170));
    }
    currentcolour=colour[x][y];
  }  
  public void enablingbuttons()//enabling buttons after restarting the game
  {
      reset.setEnabled(true);
      next.setEnabled(true);
      up.setEnabled(true);
      down.setEnabled(true);
      right.setEnabled(true);
      left.setEnabled(true);
      enablingthegrid();
  }  
  public void enablingthegrid()//for loop that goes all the buttons to enable them
  {
    int move=0;
    for (int i=0; i<6; i++)
    {
      for (int j=0; j<6; j++)
      {
        buttons[move].setEnabled(true);
      move++;
      }
    }
  }
  public void up()
  {
    if (!updown())//if it's not a car that moves up and down
      showStatus("You can't move that way!");
    else
    {
      findtopleft();
      if ((topx-1>=0)&&(topx-1<=5)&&colour[topx-1][topy]=='n')// if it's a valid place to move (not off the grid or on top of another car)
      {
        moves++;
        colour[topx-1][topy]=colour[topx][topy];
        num[topx-1][topy]=num[topx][topy];
        colour[topx][topy]=colour[topx+1][topy];
        num[topx][topy]=num[topx+1][topy];
        if ((currentcolour!='y')&&(currentcolour!='d'))
        {
          colour[topx+1][topy]='n';
          num[topx+1][topy]=0; 
        }
        else 
        {
          colour[topx+1][topy]=colour[topx+2][topy];
          num[topx+1][topy]=num[topx+2][topy];
          colour[topx+2][topy]='n';
          num[topx+2][topy]=0;
        }
        redraw();
      }
    }
  } 
  public void ontonext()//changing levels... making the displayed array change value for the level that is next
  {
    if (level>9)
      level=0;
    
    levellabel.setIcon(createImageIcon("lvl"+(level+1)+".jpg"));
    
    for (int i=0; i<row; i++)
    {
      for (int j=0; j<row; j++)
      {
        colour[i][j]= colLevels[level][i][j];
        num[i][j]= numLevels[level][i][j];
      }
    }
    redraw();
  } 
  public void right()//moving the car right
  {
    if (!leftright())// if it's a car that doesn't move left and right
      showStatus("You can't move that way");
    else
    {
      findrightmost();//find the right most piece
      if ((righty+1>=0)&&(righty+1<=5)&&(colour[rightx][righty+1]=='n'))//if it is going to a valid place, then only move it
      {
        moves++;
        colour[rightx][righty+1]=colour[rightx][righty];// adjust everything to its new location.
        num[rightx][righty+1]=num[rightx][righty];
        colour[rightx][righty]=colour[rightx][righty-1];
        num[rightx][righty]=num[rightx][righty-1];
        if (currentcolour!='l')
        {
          colour[rightx][righty-1]='n';
          num[rightx][righty-1]=0;
        }
        else 
        {
          colour[rightx][righty-1]=colour[rightx][righty-2];
          num[rightx][righty-1]=num[rightx][righty-2];
          colour[rightx][righty-2]='n';
          num[rightx][righty-2]=0;
        }
        redraw();
      }
    }
  }  
  public void left()//moving the car left
  {
    if (!leftright())
      showStatus("You can't move that way!");
    else 
    {
      findleftmost();
      if ((lefty-1>=0)&&(lefty-1<=5)&&(colour[leftx][lefty-1]=='n'))// if it's going to a valid place (not on top of another car or out of the grid)
      {
        moves++;
        colour[leftx][lefty-1]=colour[leftx][lefty];
        num[leftx][lefty-1]=num[leftx][lefty];
        colour[leftx][lefty]=colour[leftx][lefty+1];
        num[leftx][lefty]=num[leftx][lefty+1];
        if (currentcolour!='l')
        {
          colour[leftx][lefty+1]='n';
          num[leftx][lefty+1]=0;
        }
        else 
        {
          colour[leftx][lefty+1]=colour[leftx][lefty+2];
          num[leftx][lefty+1]=num[leftx][lefty+2];
          colour[leftx][lefty+2]='n';
          num[leftx][lefty+2]=0;
        }
        redraw();
      }
    }
  }
  public void down()
  {
    if (!updown())// if it's not a car that moves up and down
      showStatus("You can't move that way!");
    else
    {
      finddownmost();
      if ((downx+1>=0)&&(downx+1<=5)&&(colour[downx+1][downy]=='n'))// move only if it wants to go to a valid place (on the screen and empty space)
      {
        moves++;
        colour[downx+1][downy]=colour[downx][downy];
        num[downx+1][downy]=num[downx][downy];
        colour[downx][downy]=colour[downx-1][downy];
        num[downx][downy]=num[downx-1][downy];
        if ((currentcolour!='y')&&(currentcolour!='d'))
        {
          colour[downx-1][downy]='n';
          num[downx-1][downy]=0;      
        }
        else 
        {
          colour[downx-1][downy]=colour[downx-2][downy];
          num[downx-1][downy]=num[downx-2][downy];
          colour[downx-2][downy]='n';
          num[downx-2][downy]=0;
        }
        redraw();
      }
    } 
  }
  public void levelsbeat()//change the levelswon variable to keep track of which levels have been beaten
  {
    if (level==0)
      {
        if (lvl1won==false)//if the level hasn't been beaten yet, then set it to beaten and update this in the update progress method
        {
        lvl1won=true;
        updateprogress();
        }
      }
      else if (level==1)
      {
        if (lvl2won==false)
        {
        lvl2won=true;
        updateprogress();
        }
      }
      else if (level==2)
      {
        if (lvl3won==false)
        {
        lvl3won=true;
        updateprogress();
        }
      }
      else if (level==3)
      {
        if (lvl4won==false)
        {
        lvl4won=true;
        updateprogress();
        }
      }
      else if (level==4)
      {
        if (lvl5won==false)
        {
        lvl5won=true;
        updateprogress();
        }
      }
      else if (level==5)
      {
        if (lvl6won==false)
        {
        lvl6won=true;
        updateprogress();
        }
      }
      else if (level==6)
      {
        if (lvl7won==false)
        {
        lvl7won=true;
        updateprogress();
        }
      }
      else if (level==7)
      {
        if (lvl8won==false)
        {
        lvl8won=true;
        updateprogress();
        }
      }
      else if (level==8)
      {
        if (lvl9won==false)
        {
        lvl9won=true;
        updateprogress();
        }
      }
      else
      {
         if (lvl10won==false)
        {
        lvl10won=true;
        updateprogress();
        }
      }
  }
  public void didWin()
  {
    if ((colour[2][5]=='r')&&(num[2][5]==2))//at the end of the red car's row
    {
      levelsbeat();//runs the method above to set the completed levels equal to true
      //if there are still levels to beat, then just keep going to the next lvl
      if (lvl1won==false||lvl2won==false||lvl3won==false||lvl4won==false||lvl5won==false||lvl6won==false||lvl7won==false||lvl7won==false||lvl8won==false||lvl9won==false||lvl10won==false)
      {
      Object [] options = {"OK", "CANCEL"};
      JOptionPane.showOptionDialog (null, "You crossed the traffic! Click Next!","Level "+(level+1)+" Completed",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                                    null, options, options [0]);
 
      level++; 
      ontonext();
      redraw();
      }  
      else
      {
              Object [] options = {"OK", "CANCEL"};
      JOptionPane.showOptionDialog (null, "Click Play Again, And Try To Use Less Moves!","All 10 Levels Solved!",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                                    null, options, options [0]);
      disablingbuttons();
      disablingthegrid();
      colorstatus.setIcon(createImageIcon("colorblank.jpg"));
      //disable all buttons other than the replay button. in the replay method, enable them again. set level and other things to 0/start them from 0.      
      } 
    }
  }   
  public void disablingbuttons()//disable the other buttons
  {
          reset.setEnabled(false);
      next.setEnabled(false);
      up.setEnabled(false);
      down.setEnabled(false);
      right.setEnabled(false);
      left.setEnabled(false);
  }
  public void disablingthegrid()//disable the grid when we want the user to click play again
  {
    int move=0;
    for (int i=0; i<6; i++)
    {
      for(int j=0; j<6; j++)
      {
        buttons[move].setEnabled(false);
        move++;
      }
    }
  } 
  public void updateprogress()//updates the progress bar
  {
    prog=prog+10;
    progress.setValue(prog);
  }  
  protected static ImageIcon createImageIcon (String path) 
  { 
    java.net.URL imgURL = FallingLeaves.class.getResource (path); 
    if (imgURL != null) 
    {            
      return new ImageIcon (imgURL);         
    } else 
    { 
      System.err.println ("Couldn't find file: " + path);             
      return null;        
    } 
  }  
}
