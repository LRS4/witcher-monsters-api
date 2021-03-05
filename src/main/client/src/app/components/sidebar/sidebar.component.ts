import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Monster } from '../../models/monster';
import { DataService } from '../../services/data.service';
import { MonsterService } from '../../services/monster.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.less']
})
export class SidebarComponent implements OnInit {
  
  public title = 'Monsters';
  public monsters: Monster[] = [];
  public monstersByCategory: any[] = [];
  public selectedMonster: any;

  constructor(private monsterService: MonsterService,
    private dataService: DataService) { }

  ngOnInit() {
    this.getMonsters();
    this.dataService.selectedMonster.subscribe(selectedMonster => {
      return this.selectedMonster = selectedMonster;
    });
  }

  public getMonsters(): void {
    this.monsterService.getMonsters().subscribe(
      (response: Monster[]) => {
        this.monsters = response;
        this.monstersByCategory = this.groupMonstersByCategory(response);
      }
    ),
    (error: HttpErrorResponse) => {
      console.log(error.message);
    }
  }

  public groupMonstersByCategory(monsters: any[]): any[] {
    return monsters.reduce((monstersByCategory, monster) => {
      const category = monster['category']['displayName'];
      if (category in monstersByCategory) {
        return {
          ...monstersByCategory,
          [category]: monstersByCategory[category].concat(monster)
        }
      }
      return {
        ...monstersByCategory, 
        [category]: [monster]
      }
    }, {})
  }

  public onSelect(selectedMonster: Monster): void {
    this.selectedMonster = selectedMonster;
    this.dataService.changeSelectedMonster(selectedMonster);
  }

}
