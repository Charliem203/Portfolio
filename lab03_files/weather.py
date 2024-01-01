# Template file for Lab03 -- weather. By Peter Wang and Daniel Kluver
# Additions made by: Charlie Madison

# Import Statements
import csv  # imported for DictReader
import math  # imported for


# provided functions -- one handles some tedious loading details, and the other can help make sure you know what you're
# working with -- it's worth reading both carefully, and trying to learn from what you're seeing.


def load(filename):
    """load the CSV file by name, return list of dictionaries, each dictionary describes one row. of the file"""
    reader = csv.DictReader(
        open(filename), dialect="excel", skipinitialspace=True
    )
    return list(reader)


# provided function
def min_min_temp(file_list):
    """The input is a list of dictionaries like would be returned by the load function. The output is the minimum temperature
    observed in the dataset. We are tacitly assuming that the min temperature for a day is always below the max temperature
    """
    min_temp = math.inf
    for row in file_list:
        row_min_temp = float(row["Min_Temperature"])
        if row_min_temp < min_temp:
            min_temp = row_min_temp
    return min_temp


# Put your functions below this.
def F_to_C(f_temp):
    """ Takes in temp from CSV file and converts it to celsius and then returns it. The input and output are always numbers"""

    c_temp = (5*(f_temp-32))/9
    return c_temp

def F_to_C_file(file_list):
    """ Interate through the dictionaries"""
    for data_dict in file_list:
        """ Checks for Max_Temperature value"""
        if 'Max_Temperature' in data_dict:
                """ Converts it to a float and stores it"""
                temp_f = float(data_dict['Max_Temperature'])
                """ Converts to celsius"""
                temp_c = F_to_C(temp_f)
                data_dict['Max_Temperature'] = temp_c
    """ Repeats past step just with Min_Temperature instead of Max_temperature"""
    for data_dict in file_list:
        if 'Min_Temperature' in data_dict:
                temp_f = float(data_dict['Min_Temperature'])
                temp_c = F_to_C(temp_f)
                data_dict['Min_Temperature'] = temp_c


def clean(file_list, column):
    """ Creates empty list"""
    clean_list = []

    """Iterares through dictionaries"""
    for data_dict in file_list:
        """ Finds the column"""
        if column in data_dict:
            """ Finds the value at each column and if it's not one of the special ones it appends it with that value"""
            if data_dict[column] not in ('T', 'M', 'S', 'A', ''):
                clean_list.append(data_dict)

    return clean_list


def average(file_list, column):
     """Sets up running total and count to find average later"""
     total = 0.0
     count = 0
     """Iterates through dictionaries"""
     for data_dict in file_list:
        """Finds if it's in the chosen column"""
        if column in data_dict:
            """If it is then it trys to add it to the total"""
            try:
                value = float(data_dict[column])
                total += value
                count += 1
                """If it's sometime that cannot be a float"""
            except ValueError:
                pass
        """ Accounts for empty list and calculates average"""
        if count > 0:
            average_value = total / count
            return average_value
        else:
            return 0.0


def total_rain_by_year(file_list):
    """ Initialize the dictionary to store yearly sums """
    yearly_precipitation = {}  

    """ Iterate through the list of dictionaries """
    for data_dict in file_list:
        """ Check if 'date' and 'Precipitation' keys exist in the dictionary """
        if 'date' in data_dict and 'Precipitation' in data_dict:
            date = data_dict['date']
            precipitation = data_dict['Precipitation']

            """ Extract the year from the date string and convert it to an integer """
            year = int(date[:4])

            """ Convert precipitation from string to float and add it to the yearly sum """
            try:
                precipitation_value = float(precipitation)
                if year in yearly_precipitation:
                    yearly_precipitation[year] += precipitation_value
                else:
                    yearly_precipitation[year] = precipitation_value
            except ValueError:
                """ Handle the case where precipitation is not a valid float """
                pass

    return yearly_precipitation


