package com.cnx.endlesstalestwo.data.skills;

import com.cnx.endlesstalestwo.data.DataHelper;

public class SkillsDataManager extends DataHelper {

    @Override
    public void generate() {
        new AttackSkills().generate();
        new SupportSkills().generate();
        new HealingSkills().generate();
    }
}
