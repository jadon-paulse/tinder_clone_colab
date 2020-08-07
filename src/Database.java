import java.io.*;
import java.util.*;
public class Database {

    ArrayList<Profile> allProfiles = new ArrayList<Profile>();
    ArrayList<Profile> maleProfiles = new ArrayList<Profile>();
    ArrayList<Profile> femaleProfiles = new ArrayList<Profile>();
    FileWriter csvWriter;

    Database() {
        try {
            this.csvWriter = new FileWriter("swipes.csv");
        }
        catch(Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public void readFromCSV(String filename) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int i = 0;

        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if(i>0){
                    Person p = new PersonBuilder().setName(data[0]).setAge(Integer.parseInt(data[1])).setGender(data[2]).setLocation(data[3]).setBio(data[4]).createPerson();
                    Image image1 = new ImageBuilder().setUrl(data[5]).setTitle(data[6]).setDescription(data[7]).createImage();
                    Image image2 = new ImageBuilder().setUrl(data[8]).setTitle(data[9]).setDescription(data[10]).createImage();
                    Image image3 = new ImageBuilder().setUrl(data[11]).setTitle(data[12]).setDescription(data[13]).createImage();
                    Image[] images = new Image[3];
                    images[0] = image1;
                    images[1] = image2;
                    images[2] = image3;
                    Profile profile = new Profile(p,images);
                    this.allProfiles.add(profile);

                    if(profile.getPerson().getGender().toUpperCase().equals("MALE")) {
                        this.maleProfiles.add(profile);
                    }
                    else {
                        this.femaleProfiles.add(profile);
                    }
                }

                i++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<Profile> getAllProfiles() {
        return this.allProfiles;
    }
    public ArrayList<Profile> getMaleProfiles() {
        return this.maleProfiles;
    }
    public ArrayList<Profile> getFemaleProfiles() {
        return this.femaleProfiles;
    }

    public void WritetoCSV(Profile profile){
        Person p = profile.getPerson();
        List<List<String>> rows = Arrays.asList(
                Arrays.asList(p.getName(), p.getAge()+"", p.getGender(), p.getLocation(), p.getBio())
        );

        try {
            for (List<String> rowData : rows) {
                this.csvWriter.append(String.join(",", rowData));
                this.csvWriter.append("\n");
            }
        }
        catch(Exception e) {
            System.out.println("Error: " + e.toString());
        }

    }

    public void closeFileWriting() {
        try {
            this.csvWriter.flush();
            this.csvWriter.close();
        }
        catch(Exception e) {
            System.out.println("Error: " + e.toString());
        }


    }


}