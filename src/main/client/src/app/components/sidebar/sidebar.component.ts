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
  public selectedMonster: any;
  public monstersByCategory: any[] = [];
  public accordionCategoryIsOpen: string[] = [];

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
        let monstersByCategory = this.groupMonstersByCategory(response);
        this.monstersByCategory = this.sortMonstersByCategoryAlphabetically(monstersByCategory);
      }
    ),
    (error: HttpErrorResponse) => {
      console.log(error.message);
    }
  }

  public sortMonstersByCategoryAlphabetically(monstersByCategory: any[]): any[] {
    for (let category in monstersByCategory) {
      monstersByCategory[category] = monstersByCategory[category].sort((a: any, b: any) => {
        return a.displayName.localeCompare(b.displayName);
      });
    }

    return monstersByCategory;
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

  public toggleCategoryActive(categoryName: string): void {
    if (this.accordionCategoryIsOpen.includes(categoryName)) {
      this.accordionCategoryIsOpen = [...this.accordionCategoryIsOpen].filter(item => {
        return item !== categoryName;
      });
    } else {
      this.accordionCategoryIsOpen.push(categoryName);
    }
  }

  public onSelect(selectedMonster: Monster): void {
    this.selectedMonster = selectedMonster;
    this.dataService.changeSelectedMonster(selectedMonster);
  }

}
