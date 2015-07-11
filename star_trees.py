#!/usr/bin/env python


class StarTree:

    def __init__(self, levels):

        # This algorithm doesn't actually
        # need any state here -- in Python,
        # it doesn't even need to be in a class.

        # I'm making the first pass at all
        # the StarTrees feature some OOP
        # infrastructure to serve as an
        # accessible example and enable
        # some testing modularity in case
        # anyone wants to try timing the
        # different implementations and
        # languages against each other.

        self.levels = levels

    def print_tree(self):

        # I spread this one out to make it more readable.

        for each_level in range(1, (self.levels + 1)):

            for each_row_index in range(0, (each_level + 1)):

                spaces = " " * (self.levels - each_row_index)
                stars = "*" * ((each_row_index * 2) + 1)

                print("{}{}".format(spaces, stars))


if __name__ == '__main__':

    # For ease of testing, sys.argv
    # lets the user supply a number
    # to the program at execution.
    import sys

    if len(sys.argv) == 2:
        tree_size = int(sys.argv[1])
    else:
        tree_size = 3

    new_tree = StarTree(tree_size)
    new_tree.print_tree()
