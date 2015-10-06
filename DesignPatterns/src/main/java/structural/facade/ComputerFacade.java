package structural.facade;

/**
 * Created by Sergei on 08.09.2015.
 */
public class ComputerFacade {

    private static final int BOOT_ADDRESS = 2;
    private static final long BOOT_SECTOR = 2;
    private static final int SECTOR_SIZE = 7;
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.freeze();
        memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
    }
}
