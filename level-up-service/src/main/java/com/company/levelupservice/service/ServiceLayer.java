package com.company.levelupservice.service;

import com.company.levelupservice.dao.LevelUpDao;
import com.company.levelupservice.model.LevelViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceLayer {

    private LevelUpDao levelUpDao;

    @Autowired
    public ServiceLayer(LevelUpDao levelUpDao) {
        this.levelUpDao = levelUpDao;
    }

    public LevelViewModel addLevelUpEntry(LevelViewModel lvm){
        return null;
    }

    public LevelViewModel findLevelUpEntry(int level_up_id){
        return null;
    }

    public List<LevelViewModel> findAllLevelUpEntries(){
        return null;
    }

    public void updateLevelUpEntry(LevelViewModel lvm){

    }

    public void removeLevelUpEntry(int level_up_id){}
}
