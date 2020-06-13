
package com.sg.foundations.flowcontrol.ifs;
import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */
public class MiniZork {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house, with a barn to the side.");
        System.out.println("The house has a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.println("Go to the house, the barn, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.println("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.println("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you're alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) { 
                System.out.println("You stick you hand inside the mailbox.");
                System.out.println("It's really quite sticky. So ... so very sticky.");
                System.out.println("Keep feeling around or try to pull your hand out and run away?");
                action = userInput.nextLine();

                if (action.equals("keep feeling around")) {
                    System.out.println("You grasp something solid and pull your hand out to reveal a diamond!");
                    System.out.println("Your curiosity has paid off this time!");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you're alive. Possibly a wise choice.");
                }   
            }
        }
        else if (action.equals("go to the house")) { 
             System.out.println("You reach the boarded up door and find the boards rotting and easy to remove.");
            System.out.println("It smells pretty bad in here");
            System.out.println("Walk inside or call out? ");
            action = userInput.nextLine();

            if (action.equals("walk inside")) {
                System.out.println("You take a few steps into the house");
                System.out.println("You can't see much but there is a faint light coming from ahead of you...");
                System.out.println("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, trespassing isn't a good idea.");
                    System.out.println("An old lady in pajamas comes running towards you, swinging a rolling pin.");
                    System.out.println("You run out, apologizing, eventually escaping her but covered in welts.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you're alive. Possibly a wise choice.");
                }
            } else if (action.equals("call out")) { 
                System.out.println("You call out 'hello?'");
                System.out.println("'Who's there?' a meek voice calls from the distance...");
                System.out.println("Answer back or run away?");
                action = userInput.nextLine();

                if (action.equals("answer back")) {
                    System.out.println("you introduce yourself and apologize for intruding");
                    System.out.println("An old lady appears, yieliding a rolling pin");
                    System.out.println("'Oh nonsense' she says, 'I love company and I'm just baking some cookies'");
                    System.out.println("'Please come in and have some!'");
                    System.out.println("You join her and discover that she's a baking genius. Who knew cookies could be this good?!");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you're alive. Possibly a wise choice.");
                }   
            }
        }
        else if (action.equals("the barn")) { 
             System.out.println("You head to the barn.");
            System.out.println("There are a lot of boards keeping this place shut...");
            System.out.println("Keep trying to pry the boards open by hand or look around for a tool?");
            action = userInput.nextLine();

            if (action.equals("keep trying")) {
                System.out.println("You pry and pry at the wood");
                System.out.println("it's starting to give a little but your hands are getting sore...");
                System.out.println("keep prying or try kicking the boards in");
                action = userInput.nextLine();

                if (action.equals("keep prying")) {
                    System.out.println("Ouch! You've got a splinter! ");
                    System.out.println("When was your last tetanus shot again? ");
                    System.out.println("Better head home and call your doctor.");
                } else if (action.equals("try kicking the boards")) {
                    System.out.println("Your kick works and the board breaks, but suddenly you are ambushed by bats");
                    System.out.println("You run screaming, flailing your arms like an idiot.");
                }
            } else if (action.equals("look around")) { 
                System.out.println("You walk around to the side of the barn");
                System.out.println("You notice something wooden off in the distance but it's too dark to tell what it is...");
                System.out.println("Investigate the wooden thing or keep walking around the barn?");
                action = userInput.nextLine();

                if (action.equals("keep feeling around")) {
                    System.out.println("You notice a glint of glass... could it be, an unboarded window?");
                    System.out.println("You peer inside and see hundreds of bats");
                    System.out.println("Good thing you didn't break in there!");
                } else if (action.equals("investigate the wooden thing")) {
                    System.out.println("You walk towards the wooden thing when suddenly 'WHACK'");
                    System.out.println("You've stepped on a rake and knocked yourself unconscious. See ya in the morning!");
                }   
            }
        }
    }
    
}
