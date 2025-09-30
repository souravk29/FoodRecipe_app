# Branch Configuration Guide

## Current Branch Status

This repository currently has the following branches:
- ✅ `main` - Primary development branch
- ✅ `fix-typo` - Feature branch
- ✅ `souravk29-patch-1` - Patch branch

**Note:** There is no `master` branch in this repository.

## Setting `main` as Default Branch on GitHub

To set `main` as the default branch for this repository, follow these steps:

### Steps to Change Default Branch on GitHub:

1. **Navigate to Repository Settings**
   - Go to https://github.com/souravk29/FoodRecipe_app
   - Click on **Settings** tab (requires admin access)

2. **Change Default Branch**
   - In the left sidebar, ensure you're on the **General** section
   - Scroll down to the **Default branch** section
   - Click the switch/edit button (pencil icon or branch switcher)
   - Select `main` from the dropdown
   - Click **Update** or **I understand, update the default branch**

3. **Confirm the Change**
   - GitHub will show a warning about the impact of changing the default branch
   - Confirm the change

### Impact of Changing Default Branch:

- New pull requests will target `main` by default
- New clones will check out `main` by default
- Branch protection rules may need to be updated
- CI/CD workflows may need verification

## Removing Master Branch (If It Exists)

If a `master` branch exists and you want to remove it:

### Before Removing:

1. **Ensure all important changes are merged to `main`**
   ```bash
   git checkout main
   git pull origin main
   git log --oneline --graph --all
   ```

2. **Check for any pull requests targeting master**
   - Go to Pull Requests tab
   - Update any open PRs to target `main` instead

3. **Update branch protection rules**
   - Ensure protection rules are set on `main`, not `master`

### To Delete Master Branch:

**From GitHub Web Interface** (Recommended):
1. Go to the branches page: https://github.com/souravk29/FoodRecipe_app/branches
2. Find the `master` branch
3. Click the trash icon to delete it

**From Command Line** (If you have push access):
```bash
# Delete local master branch
git branch -d master

# Delete remote master branch
git push origin --delete master
```

## Updating Local Repository

After changing the default branch on GitHub, update your local repository:

```bash
# Fetch latest changes
git fetch origin

# If you have a local master branch, delete it
git branch -d master

# Set main as your default local branch
git checkout main
git pull origin main

# Update remote tracking
git remote set-head origin main
```

## Verify Configuration

Check your current configuration:

```bash
# Check current branch
git branch

# Check remote branches
git branch -r

# Check default branch
git remote show origin
```

## Recommendations

1. ✅ Use `main` as the primary development branch
2. ✅ Update any CI/CD configurations to reference `main`
3. ✅ Update documentation that references `master`
4. ✅ Inform team members about the branch name change
5. ✅ Update any external integrations or webhooks

## Additional Resources

- [GitHub: Renaming a branch](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-branches-in-your-repository/renaming-a-branch)
- [GitHub: Changing the default branch](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-branches-in-your-repository/changing-the-default-branch)
