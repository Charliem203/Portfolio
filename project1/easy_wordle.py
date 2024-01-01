from wordle import check_word
import random
from display_utility import green, grey, yellow
from words import words



def filter_word_list(words, clues):
    # Creates empty word list
    filtered_words = []
    # Iterates words and tests to see if they are valid 
    for possible_word in words:
        possible_word = possible_word.upper()
        is_valid = all(check_word(possible_word, guess) == expected_clues for guess, expected_clues in clues)

        if is_valid:
            filtered_words.append(possible_word.lower())

    return filtered_words

def easy_game(secret):
    # Creates lists similar to game function
    secret = secret.lower()
    guesses = []
    max_guesses = 6
    possible_words = words.copy()
    # Sets up loop for possible words sets it up to display later
    for i in range(max_guesses):
        print("Number of possible words:", len(possible_words))
        if len(possible_words) <= 5:
            words_to_display = possible_words
        else:
            words_to_display = random.sample(possible_words, 5)
        # Prints out possible words
        print("Possible words:", ", ".join(words_to_display))
        # Creates loop for user guesses
        while True:
            user_guess = input("> ").lower()
            if len(user_guess) == 5 and user_guess in words:
                i -= 1
                break
            else:
                print("Not a valid word. Try again.")
        # Sets for clues and possible words
        clues = check_word(secret, user_guess)
        possible_words = filter_word_list(possible_words, [(user_guess, clues)])
        # End cases, win game or run out of guesses
        if user_guess == secret:
            print("Congratulations! You've guessed the word: " + secret)
            break
    else:
        print("Out of guesses. The secret word was: " + secret)

    if __name__ == "__main":
        secret_word = random.choice(words)
        easy_game(secret_word)