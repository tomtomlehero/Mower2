package fr.mla.mower2.core.business.service;

import fr.mla.mower2.core.command.Command;
import fr.mla.mower2.core.command.imp.ACommand;
import fr.mla.mower2.core.command.imp.DCommand;
import fr.mla.mower2.core.command.imp.GCommand;
import fr.mla.mower2.core.model.configuration.MowItNowConfiguration;
import fr.mla.mower2.core.model.configuration.MowerConfiguration;
import fr.mla.mower2.core.model.mower.Mower;
import fr.mla.mower2.core.model.mower.impl.DGAMower;
import fr.mla.mower2.core.util.InstructionEnum;
import org.springframework.stereotype.Service;

@Service
public class MowItNowService {

    private Command commandD = new DCommand();
    private Command commandG = new GCommand();
    private Command commandA = new ACommand();

    public String mowIt(MowItNowConfiguration mowItNowConfiguration) {

        String finalPositions = "";

        for (MowerConfiguration mowerConfiguration : mowItNowConfiguration.getMowerConfigurations()) {

            Mower mower = new DGAMower(
                    mowItNowConfiguration.getMaxX(),
                    mowItNowConfiguration.getMaxY(),
                    mowerConfiguration.getStartX(),
                    mowerConfiguration.getStartY(),
                    mowerConfiguration.getStartO()
            );

            commandsDriveMower(mower);

            mowerMow(mowerConfiguration);
            finalPositions += " $$$$$ MOWER #"
                     + mowerConfiguration.getMowerNum() + " finished ["
                     + mower.getX() + " "
                     + mower.getY() + " "
                     + mower.getOrientation().name() + "]";

        }

        return finalPositions;

    }



    private void commandsDriveMower(Mower mower) {
        commandD.setMower(mower);
        commandG.setMower(mower);
        commandA.setMower(mower);

    }


    private void mowerMow(MowerConfiguration mowerConfiguration) {

        for (InstructionEnum instruction : mowerConfiguration.getInstructions()) {

            switch (instruction) {

                case D:
                    commandD.execute();
                    break;
                case G:
                    commandG.execute();
                    break;
                case A:
                    commandA.execute();
                    break;
            }
        }
    }

}
