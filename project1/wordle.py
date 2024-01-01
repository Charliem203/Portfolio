# Made by Charlie Madison
from display_utility import green, grey, yellow
from words import words
import random


def check_word(secret, guess):
    # Creates output list full of grey's as default and creates counts for both secret and count to store letters to avoid repeats
    output = ['grey'] * 5
    secret_count = {}
    guess_count = {}


    # For loop to check for double letters
    for i in range(5):
        letter = secret[i]
        if letter in secret:
            if letter in secret_count:
                secret_count[letter] += 1
            else:
                secret_count[letter] = 1

    secret_list = []

    for i in range(5):
        secret_list.append([])
    # Tests for repeats in guess_count and for greens
    for i in range(5):
        letter = guess[i]
        if letter in secret:
            if letter in guess_count:
                guess_count[letter] += 1
            else:
                guess_count[letter] = 1
        if guess[i] == secret[i]:
            output[i] = "green"
        # Makes repeated letters grey
            if len(secret_list[i]) != 0:
                for index in secret_list[i]:
                    output[index] = "grey"
    # Tests for yellows and makes sure they're not repeats
        elif guess[i] in secret and guess[i] != secret[i] and guess_count[letter] <= secret_count[letter]:
            output[i] = "yellow"
            secret_list[secret.find(guess[i])].append(i)
    return output

def known_word(clues):
    # Creates known list and fills it in with only green letters
    known = ["_", "_", "_", "_", "_"]
    
    for guesses, colors in clues:
        for i in range(5):
            if colors[i] == "green":
                known[i] = guesses[i]
    known_string = "".join(known)
    return known_string
    

def no_letters(clues):
    # Fills not_in_word list with grey letters with no repeats
    not_in_word = []
    
    for guesses, colors in clues:
        for i in range(5):
            if colors[i] == "grey" and guesses[i] not in not_in_word:
                not_in_word.append(guesses[i])
            if (guesses[i] in not_in_word) and colors[i] == "green":
                    not_in_word.remove(guesses[i])

    
    not_in_word_string = "".join(sorted(not_in_word))
    return not_in_word_string


def yes_letters(clues):
    # fills in_word list with both yellow and green letters with no repeats
    in_word = []

    for guesses, colors in clues:
        for i in range(5):
            if colors[i] == "yellow" or colors[i] == "green":
                    if(guesses[i] in in_word) == False:
                        in_word.append(guesses[i])

    
    not_in_word_string = "".join(sorted(in_word))
    return not_in_word_string


def game(secret):
    # Sets up guesses and max_guess and lowercases secret for comparison
    secret = str(secret).lower()
    guesses = []
    max_guesses = 6
    # Prints out empty list before first guess
    print("Known: "+ known_word(guesses).upper())
    print("Green/Yellow Letters: " + yes_letters(guesses).upper())
    print("Grey letters: " + no_letters(guesses).upper())
    # Sets up guess loop and tests if it's valid word
    for i in range(max_guesses):
        while True:
            user_guess = input("> ").lower()
            if len(user_guess) == 5 and user_guess in words:
                i -= 1
                break
            else:
                print("Not a word. Try again.")
        # Takes the guess and tests it for the colors and then adds it to the appropriate lists
        hints = check_word(secret, user_guess)
        guess_hints = [user_guess] + [hints]
        guesses.append(guess_hints)

        colors = check_word(secret, user_guess)
        # Runs for the display of colors
        for i in range(5):
            if colors[i] == 'green':
                green(user_guess[i])
            elif colors[i] == 'yellow':
                yellow(user_guess[i])
            else:
                grey(user_guess[i])
        # Prints out the filled lists with the guessed letters
        print("\n")
        print("Known: "+ known_word(guesses).upper())
        print("Green/Yellow Letters: " + yes_letters(guesses).upper())
        print("Grey letters: " + no_letters(guesses).upper())




        if user_guess == secret:
            print("Congratulations! You've guessed the word: " + secret)
            break
    else:
        print(f"Out of guesses. The secret word was: " + secret)


if __name__ == "__main__":
    secret_word = random.choice(words)
    game(secret_word)