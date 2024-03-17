// Cameron Berg
// Class: CS&141
// Date 1/16/24
// Lab 2 Card Shuffling and Dealing Program
// Purpose: This program is designed to create and shuffle a deck of cards
// that is then delt out to the user. It will tell you if you have a pair, 2 pair,
// full house, ect. 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Creates cards
class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class DeckManager {
    private List<Card> deck;

    public DeckManager() {
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        deck = new ArrayList<>();

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }
    // Calls Card and deals and tells if deck is empty
    public Card dealCard() {
        if (deck.isEmpty()) {
            System.out.println("Deck is empty. Please shuffle or reset.");
            return null;
        }
        return deck.remove(0);
    }

    public void resetDeck() {
        initializeDeck();
    }

    // Check for a pair in the hand
    public boolean hasPair(List<Card> hand) {
        Map<String, Integer> rankCount = getRankCount(hand);
        for (int count : rankCount.values()) {
            if (count == 2) {
                return true;
            }
        }
        return false;
    }

    // Check for two pairs in the hand
    public boolean hasTwoPairs(List<Card> hand) {
        Map<String, Integer> rankCount = getRankCount(hand);
        int pairCount = 0;
        for (int count : rankCount.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    // Check for three of a kind in the hand
    public boolean hasThreeOfAKind(List<Card> hand) {
        Map<String, Integer> rankCount = getRankCount(hand);
        for (int count : rankCount.values()) {
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    // Check for four of a kind in the hand
    public boolean hasFourOfAKind(List<Card> hand) {
        Map<String, Integer> rankCount = getRankCount(hand);
        for (int count : rankCount.values()) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    // Check for a flush in the hand
    public boolean hasFlush(List<Card> hand) {
        String suit = hand.get(0).getSuit();
        for (Card card : hand) {
            if (!card.getSuit().equals(suit)) {
                return false;
            }
        }
        return true;
    }

    // Check for a straight in the hand
    public boolean hasStraight(List<Card> hand) {
        Collections.sort(hand, Comparator.comparingInt(card -> getFaceValue(card.getRank())));
        for (int i = 0; i < hand.size() - 1; i++) {
            if (getFaceValue(hand.get(i + 1).getRank()) - getFaceValue(hand.get(i).getRank()) != 1) {
                return false;
            }
        }
        return true;
    }

    // Check for a full house in the hand
    public boolean hasFullHouse(List<Card> hand) {
        Map<String, Integer> rankCount = getRankCount(hand);
        boolean hasTwo = false;
        boolean hasThree = false;
        for (int count : rankCount.values()) {
            if (count == 2) {
                hasTwo = true;
            } else if (count == 3) {
                hasThree = true;
            }
        }
        return hasTwo && hasThree;
    }

    // Helper method to get the face value of a card
    private int getFaceValue(String rank) {
        switch (rank) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            case "Jack": return 11;
            case "Queen": return 12;
            case "King": return 13;
            case "Ace": return 14;
            default: return 0;
        }
    }

    // Helper method to count the occurrences of each rank in a hand
    private Map<String, Integer> getRankCount(List<Card> hand) {
        Map<String, Integer> rankCount = new HashMap<>();
        for (Card card : hand) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
        }
        return rankCount;
    }

    // Check for a pair in the hand and print output
    public void checkAndPrintPair(List<Card> hand) {
        if (hasPair(hand)) {
            System.out.println("Hand has a pair.");
        }
    }

    // Check for two pairs in the hand and print output
    public void checkAndPrintTwoPairs(List<Card> hand) {
        if (hasTwoPairs(hand)) {
            System.out.println("Hand has two pairs.");
        }
    }

    // Check for three of a kind in the hand and print output
    public void checkAndPrintThreeOfAKind(List<Card> hand) {
        if (hasThreeOfAKind(hand)) {
            System.out.println("Hand has three of a kind.");
        }
    }

    // Check for four of a kind in the hand and print output
    public void checkAndPrintFourOfAKind(List<Card> hand) {
        if (hasFourOfAKind(hand)) {
            System.out.println("Hand has four of a kind.");
        }
    }

    // Check for a flush in the hand and print output
    public void checkAndPrintFlush(List<Card> hand) {
        if (hasFlush(hand)) {
            System.out.println("Hand has a flush.");
        }
    }

    // Check for a straight in the hand and print output
    public void checkAndPrintStraight(List<Card> hand) {
        if (hasStraight(hand)) {
            System.out.println("Hand has a straight.");
        }
    }

    // Check for a full house in the hand and print output
    public void checkAndPrintFullHouse(List<Card> hand) {
        if (hasFullHouse(hand)) {
            System.out.println("Hand has a full house.");
        }
    }
}

public class DeckOfCards {
    public static void main(String[] args) {
        DeckManager deckManager = new DeckManager();

        // Shuffle the deck
        deckManager.shuffleDeck();

        // Deal and display five cards
        List<Card> hand = new ArrayList<>();
        System.out.println("Dealing 5 cards:");
        for (int i = 0; i < 5; i++) {
            Card card = deckManager.dealCard();
            if (card != null) {
                hand.add(card);
                System.out.println(card);
            }
        }

        // Check and print hand combinations
        deckManager.checkAndPrintPair(hand);
        deckManager.checkAndPrintTwoPairs(hand);
        deckManager.checkAndPrintThreeOfAKind(hand);
        deckManager.checkAndPrintFourOfAKind(hand);
        deckManager.checkAndPrintFlush(hand);
        deckManager.checkAndPrintStraight(hand);
        deckManager.checkAndPrintFullHouse(hand);

        // Reset the deck
        deckManager.resetDeck();
    }
}
