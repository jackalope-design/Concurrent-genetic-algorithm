public interface Constraints {

    int rectSize = 30;
    int gridSizeX = 6;
    int gridSizeY = 6;
    int numParents = 10;
    int numChildren = 32;
    int poolSize = 7;
    int numGenerations = 300;
    int mutationThreshold = 5;

    char[] machineIdentifiers = {'r', 'b', 'g', 'y', 'v', 'o', 'p'};
    String machineCompareList = "rbgyvop";
}
