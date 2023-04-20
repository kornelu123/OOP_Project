package pl.edu.pwr.bum.simulation.random.events;

public interface Random {
    public Random getRandomEvent();

    public Long getRandomEventIndex(Random random);

}
