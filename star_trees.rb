#!/usr/bin/env ruby

class StarTree

    def initialize(levels)
        @levels = levels
    end

    def print_tree
        (1..@levels).each do |index|
            print_level (index)
        end
    end


    def print_level(which_tier)
        (0..which_tier).each do |index|
            spaces_count = @levels - index
            puts (" " * spaces_count) + ("*" * ((index * 2) + 1))
        end
    end

end

if __FILE__ == $0
    new_tree = StarTree.new(10)
    new_tree.print_tree
end
